// Base URL for API endpoints
const API_BASE_URL = 'http://localhost:8080';

// DOM Elements
const tabButtons = document.querySelectorAll('.tab-btn');
const tabContents = document.querySelectorAll('.tab-content');
const codeSearchForm = document.getElementById('code-search-form');
const nameSearchForm = document.getElementById('name-search-form');
const sourceCodeInput = document.getElementById('source-code');
const destinationCodeInput = document.getElementById('destination-code');
const sourceNameInput = document.getElementById('source-name');
const destinationNameInput = document.getElementById('destination-name');
const swapCodeBtn = document.getElementById('swap-code');
const swapNameBtn = document.getElementById('swap-name');
const sourceSuggestions = document.getElementById('source-suggestions');
const destinationSuggestions = document.getElementById('destination-suggestions');
const resultsContainer = document.getElementById('results-container');
const loadingSpinner = document.getElementById('loading-spinner');
const resultsHeader = document.getElementById('results-header');
const journeyDetails = document.getElementById('journey-details');
const filters = document.getElementById('filters');
const trainResults = document.getElementById('train-results');
const noResults = document.getElementById('no-results');
const recentSearches = document.getElementById('recent-searches');
const sortTimeBtn = document.getElementById('sort-time');
const sortDurationBtn = document.getElementById('sort-duration');
const filterExpressBtn = document.getElementById('filter-express');
const travelDateInput = document.getElementById('travel-date');

// Store current search results
let currentTrains = [];
let isExpressOnly = false;
let currentSource = '';
let currentDestination = '';

// Initialize the application
function init() {
    setupEventListeners();
    loadRecentSearches();
    setDefaultDate();
}

// Set default date to today
function setDefaultDate() {
    const today = new Date();
    const formattedDate = today.toISOString().split('T')[0];
    travelDateInput.value = formattedDate;
}

// Set up event listeners
function setupEventListeners() {
    // Tab switching
    tabButtons.forEach(button => {
        button.addEventListener('click', () => {
            tabButtons.forEach(btn => btn.classList.remove('active'));
            tabContents.forEach(content => content.classList.remove('active'));

            button.classList.add('active');
            const tabId = button.getAttribute('data-tab');
            document.getElementById(tabId).classList.add('active');
        });
    });

    // Form submissions
    codeSearchForm.addEventListener('submit', handleCodeSearch);
    nameSearchForm.addEventListener('submit', handleNameSearch);

    // Swap buttons
    swapCodeBtn.addEventListener('click', () => {
        const tempCode = sourceCodeInput.value;
        sourceCodeInput.value = destinationCodeInput.value;
        destinationCodeInput.value = tempCode;
    });

    swapNameBtn.addEventListener('click', () => {
        const tempName = sourceNameInput.value;
        sourceNameInput.value = destinationNameInput.value;
        destinationNameInput.value = tempName;
    });

    // Autocomplete functionality
    sourceNameInput.addEventListener('input', () => {
        if (sourceNameInput.value.length >= 2) {
            fetchStationSuggestions(sourceNameInput.value, sourceSuggestions);
        } else {
            sourceSuggestions.style.display = 'none';
        }
    });

    destinationNameInput.addEventListener('input', () => {
        if (destinationNameInput.value.length >= 2) {
            fetchStationSuggestions(destinationNameInput.value, destinationSuggestions);
        } else {
            destinationSuggestions.style.display = 'none';
        }
    });

    // Filter and sort buttons
    sortTimeBtn.addEventListener('click', () => sortTrains('time'));
    sortDurationBtn.addEventListener('click', () => sortTrains('duration'));
    filterExpressBtn.addEventListener('click', toggleExpressFilter);

    // Close suggestions when clicking outside
    document.addEventListener('click', (e) => {
        if (!e.target.closest('#source-suggestions') && e.target !== sourceNameInput) {
            sourceSuggestions.style.display = 'none';
        }
        if (!e.target.closest('#destination-suggestions') && e.target !== destinationNameInput) {
            destinationSuggestions.style.display = 'none';
        }
    });
}

// Handle search by station code
async function handleCodeSearch(e) {
    e.preventDefault();

    const sourceCode = sourceCodeInput.value.trim().toUpperCase();
    const destinationCode = destinationCodeInput.value.trim().toUpperCase();

    if (!sourceCode || !destinationCode) {
        alert('Please enter both source and destination station codes');
        return;
    }

    showLoadingSpinner();
    currentSource = sourceCode;
    currentDestination = destinationCode;

    try {
        const response = await fetch(`${API_BASE_URL}/search/byCode?sourceCode=${sourceCode}&destinationCode=${destinationCode}`);

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const data = await response.json();
        processSearchResults(data, sourceCode, destinationCode);
        saveRecentSearch('code', sourceCode, destinationCode);
    } catch (error) {
        console.error('Error fetching search results:', error);
        showNoResults();
    }
}

// Handle search by station name
async function handleNameSearch(e) {
    e.preventDefault();

    const sourceName = sourceNameInput.value.trim();
    const destinationName = destinationNameInput.value.trim();

    if (!sourceName || !destinationName) {
        alert('Please enter both source and destination station names');
        return;
    }

    showLoadingSpinner();
    currentSource = sourceName;
    currentDestination = destinationName;

    try {
        const response = await fetch(`${API_BASE_URL}/search/byName?sourceName=${encodeURIComponent(sourceName)}&destinationName=${encodeURIComponent(destinationName)}`);

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

        const data = await response.json();
        processSearchResults(data, sourceName, destinationName);
        saveRecentSearch('name', sourceName, destinationName);
    } catch (error) {
        console.error('Error fetching search results:', error);
        showNoResults();
    }
}

// Show loading spinner
function showLoadingSpinner() {
    trainResults.innerHTML = '';
    resultsHeader.classList.add('hidden');
    filters.classList.add('hidden');
    noResults.classList.add('hidden');
    loadingSpinner.classList.remove('hidden');
}

// Hide loading spinner
function hideLoadingSpinner() {
    loadingSpinner.classList.add('hidden');
}

// Show no results message
function showNoResults() {
    hideLoadingSpinner();
    resultsHeader.classList.remove('hidden');
    journeyDetails.textContent = `${currentSource} to ${currentDestination}`;
    filters.classList.add('hidden');
    noResults.classList.remove('hidden');
}

// Fetch station suggestions for autocomplete
async function fetchStationSuggestions(query, suggestionsElement) {
    // In a real application, this would connect to an API endpoint
    // For demo purposes, we're using mock data
    const mockSuggestions = [
        { name: 'Pune Junction', code: 'PUNE' },
        { name: 'Mumbai CST', code: 'CSTM' },
        { name: 'Delhi Junction', code: 'DLI' },
        { name: 'Bangalore City Junction', code: 'SBC' },
        { name: 'Chennai Central', code: 'MAS' },
        { name: 'Hyderabad Deccan', code: 'HYB' },
        { name: 'Kolkata Howrah Junction', code: 'HWH' },
        { name: 'Ahmedabad Junction', code: 'ADI' },
        { name: 'Jaipur Junction', code: 'JP' },
        { name: 'Lucknow', code: 'LKO' }
    ];

    // Filter suggestions based on query
    const filteredSuggestions = mockSuggestions
        .filter(station => station.name.toLowerCase().includes(query.toLowerCase()))
        .slice(0, 5); // Limit to 5 results

    // Display suggestions
    suggestionsElement.innerHTML = '';

    if (filteredSuggestions.length > 0) {
        filteredSuggestions.forEach(station => {
            const suggestionItem = document.createElement('div');
            suggestionItem.classList.add('suggestion-item');
            suggestionItem.textContent = `${station.name} (${station.code})`;

            suggestionItem.addEventListener('click', () => {
                if (suggestionsElement.id === 'source-suggestions') {
                    sourceNameInput.value = station.name;
                } else {
                    destinationNameInput.value = station.name;
                }
                suggestionsElement.style.display = 'none';
            });

            suggestionsElement.appendChild(suggestionItem);
        });

        suggestionsElement.style.display = 'block';
    } else {
        suggestionsElement.style.display = 'none';
    }
}

// helper function for time
function formatTime(timeString) {
    return timeString ? timeString.substring(0, 5) : '00:00';
}

function calculateDuration(start, end) {
    const [sh, sm] = start.split(':').map(Number);
    const [eh, em] = end.split(':').map(Number);

    let startMinutes = sh * 60 + sm;
    let endMinutes = eh * 60 + em;

    // If arrival is before departure, assume arrival is on the next day
    if (endMinutes < startMinutes) endMinutes += 24 * 60;

    const totalMinutes = endMinutes - startMinutes;
    const h = Math.floor(totalMinutes / 60);
    const m = totalMinutes % 60;

    return `${h}h ${m}m`;
}


// Process and display search results
function processSearchResults(data, source, destination) {
    hideLoadingSpinner();

    // If the API doesn't provide actual data, use mock data
    if (!data || !Array.isArray(data)) {
        data = generateMockTrains(source, destination);
    }

    currentTrains = data.map(item => {
        return {
            trainNumber: item.train.trainNumber,
            trainName: item.train.trainName,
            trainType: "EXPRESS", // You can customize this or add from backend
            sourceStation: item.source.stationName,
            destinationStation: item.destination.stationName,
            departureTime: formatTime(item.trainDepartureTime),
            arrivalTime: formatTime(item.trainArrivalTime),
            duration: calculateDuration(item.trainDepartureTime, item.trainArrivalTime),
            fare: Math.floor(Math.random() * 1000) + 500, // Add real fare if available
            available: Math.floor(Math.random() * 100) + 1 // Add real availability if available
        };
    });


    if (currentTrains.length === 0) {
        showNoResults();
        return;
    }

    // Update UI to show results
    resultsHeader.classList.remove('hidden');
    journeyDetails.textContent = `${source} to ${destination}`;
    filters.classList.remove('hidden');
    noResults.classList.add('hidden');

    renderTrainResults(currentTrains);
}

// Generate mock train data
function generateMockTrains(source, destination) {
    const trainTypes = ['EXPRESS', 'SUPERFAST', 'PASSENGER', 'RAJDHANI', 'SHATABDI'];
    const trainCount = Math.floor(Math.random() * 5) + 5; // 5-10 trains
    const trains = [];

    for (let i = 0; i < trainCount; i++) {
        const departureTime = getRandomTime();
        const duration = getRandomDuration();
        const arrivalTime = calculateArrivalTime(departureTime, duration);

        trains.push({
            trainNumber: Math.floor(Math.random() * 90000) + 10000,
            trainName: getRandomTrainName(),
            trainType: trainTypes[Math.floor(Math.random() * trainTypes.length)],
            sourceStation: source,
            destinationStation: destination,
            departureTime: departureTime,
            arrivalTime: arrivalTime,
            duration: duration,
            fare: Math.floor(Math.random() * 1500) + 500,
            available: Math.floor(Math.random() * 100)
        });
    }

    return trains;
}

// Get random train name
function getRandomTrainName() {
    const prefixes = ['Rajdhani', 'Shatabdi', 'Duronto', 'Sampark Kranti', 'Garib Rath', 'Jan Shatabdi', 'Superfast'];
    const names = ['Express', 'Mail', 'Passenger', 'Special'];

    return `${prefixes[Math.floor(Math.random() * prefixes.length)]} ${names[Math.floor(Math.random() * names.length)]}`;
}

// Get random time
function getRandomTime() {
    const hours = Math.floor(Math.random() * 24).toString().padStart(2, '0');
    const minutes = (Math.floor(Math.random() * 4) * 15).toString().padStart(2, '0');
    return `${hours}:${minutes}`;
}

// Get random duration
function getRandomDuration() {
    const hours = Math.floor(Math.random() * 12) + 1;
    const minutes = Math.floor(Math.random() * 4) * 15;
    return `${hours}h ${minutes}m`;
}

// Calculate arrival time based on departure time and duration
function calculateArrivalTime(departureTime, duration) {
    const [hours, minutes] = departureTime.split(':').map(Number);
    const durationHours = parseInt(duration.match(/(\d+)h/) ? duration.match(/(\d+)h/)[1] : 0);
    const durationMinutes = parseInt(duration.match(/(\d+)m/) ? duration.match(/(\d+)m/)[1] : 0);

    let arrivalHours = hours + durationHours;
    let arrivalMinutes = minutes + durationMinutes;

    if (arrivalMinutes >= 60) {
        arrivalHours += Math.floor(arrivalMinutes / 60);
        arrivalMinutes %= 60;
    }

    arrivalHours %= 24;

    return `${arrivalHours.toString().padStart(2, '0')}:${arrivalMinutes.toString().padStart(2, '0')}`;
}

// Render train results in the UI
function renderTrainResults(trains) {
    trainResults.innerHTML = '';

    let filteredTrains = [...trains];

    if (isExpressOnly) {
        filteredTrains = filteredTrains.filter(train =>
            train.trainType === 'EXPRESS' ||
            train.trainType === 'SUPERFAST' ||
            train.trainType === 'RAJDHANI' ||
            train.trainType === 'SHATABDI'
        );
    }

    if (filteredTrains.length === 0) {
        noResults.classList.remove('hidden');
        return;
    } else {
        noResults.classList.add('hidden');
    }

    filteredTrains.forEach(train => {
                const trainCard = document.createElement('div');
                trainCard.classList.add('train-card');

                trainCard.innerHTML = `
            <div class="train-info">
                <h3>${train.trainName || `Train ${train.trainNumber}`}</h3>
                <div class="train-number">#${train.trainNumber}</div>
                <div class="train-type">${train.trainType}</div>
            </div>
            <div class="train-schedule">
                <div class="depart">
                    <h4>${train.departureTime}</h4>
                    <div class="station">${train.sourceStation}</div>
                </div>
                <div class="journey-time">
                    <div class="duration">${train.duration}</div>
                </div>
                <div class="arrive">
                    <h4>${train.arrivalTime}</h4>
                    <div class="station">${train.destinationStation}</div>
                </div>
            </div>
            <div class="train-fare">
                <div class="fare-amount">₹${train.fare}</div>
                <button class="book-btn">Book Now</button>
                <div class="availability">${train.available || Math.floor(Math.random() * 100)} seats available</div>
            </div>
        `;
        
        trainResults.appendChild(trainCard);
    });
}

// Sort trains by departure time or journey duration
function sortTrains(sortBy) {
    if (sortBy === 'time') {
        sortTimeBtn.classList.add('active');
        sortDurationBtn.classList.remove('active');
        
        // Sort by departure time
        currentTrains.sort((a, b) => {
            const timeA = a.departureTime || '00:00';
            const timeB = b.departureTime || '00:00';
            return timeA.localeCompare(timeB);
        });
    } else {
        sortTimeBtn.classList.remove('active');
        sortDurationBtn.classList.add('active');
        
        // Sort by duration
        currentTrains.sort((a, b) => {
            const durationA = parseDuration(a.duration || '0h 0m');
            const durationB = parseDuration(b.duration || '0h 0m');
            return durationA - durationB;
        });
    }
    
    renderTrainResults(currentTrains);
}

// Toggle express trains filter
function toggleExpressFilter() {
    isExpressOnly = !isExpressOnly;
    
    if (isExpressOnly) {
        filterExpressBtn.classList.add('active');
    } else {
        filterExpressBtn.classList.remove('active');
    }
    
    renderTrainResults(currentTrains);
}

// Parse duration string to minutes for sorting
function parseDuration(durationStr) {
    const hours = parseInt(durationStr.match(/(\d+)h/) ? durationStr.match(/(\d+)h/)[1] : 0);
    const minutes = parseInt(durationStr.match(/(\d+)m/) ? durationStr.match(/(\d+)m/)[1] : 0);
    return hours * 60 + minutes;
}

// Save recent search to local storage
function saveRecentSearch(type, source, destination) {
    const searches = JSON.parse(localStorage.getItem('recentSearches') || '[]');
    
    // Check if this search already exists
    const existingIndex = searches.findIndex(search => 
        search.source === source && search.destination === destination
    );
    
    // If it exists, remove it to add at the beginning
    if (existingIndex !== -1) {
        searches.splice(existingIndex, 1);
    }
    
    // Add new search and limit to 5
    searches.unshift({ type, source, destination, timestamp: Date.now() });
    if (searches.length > 5) searches.pop();
    
    localStorage.setItem('recentSearches', JSON.stringify(searches));
    loadRecentSearches();
}

// Load recent searches from local storage
function loadRecentSearches() {
    const searches = JSON.parse(localStorage.getItem('recentSearches') || '[]');
    recentSearches.innerHTML = '';
    
    if (searches.length === 0) {
        const noSearchItem = document.createElement('div');
        noSearchItem.textContent = 'No recent searches';
        recentSearches.appendChild(noSearchItem);
    } else {
        searches.forEach(search => {
            const searchItem = document.createElement('div');
            searchItem.classList.add('recent-search-item');
            searchItem.innerHTML = `
                <i class="fas fa-history"></i>
                <span>${search.source} to ${search.destination}</span>
            `;
            
            // Add click handler to re-run the search
            searchItem.addEventListener('click', () => {
                if (search.type === 'code') {
                    // Switch to code tab
                    tabButtons[0].click();
                    
                    // Fill in form and submit
                    sourceCodeInput.value = search.source;
                    destinationCodeInput.value = search.destination;
                    codeSearchForm.dispatchEvent(new Event('submit'));
                } else {
                    // Switch to name tab
                    tabButtons[1].click();
                    
                    // Fill in form and submit
                    sourceNameInput.value = search.source;
                    destinationNameInput.value = search.destination;
                    nameSearchForm.dispatchEvent(new Event('submit'));
                }
            });
            
            recentSearches.appendChild(searchItem);
        });
    }
}

// Initialize the application on load
document.addEventListener('DOMContentLoaded', init);