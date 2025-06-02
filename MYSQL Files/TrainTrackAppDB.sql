use train;


select * from trains;


INSERT INTO train_stations (station_code, station_name) VALUES
('PUNE', 'Pune Junction'),
('CSTM', 'Mumbai CST'),
('NDLS', 'New Delhi'),
('BGL', 'Bangalore City'),
('HYD', 'Hyderabad Deccan');



INSERT INTO trains (train_name, train_number) VALUES
('Deccan Express', '12123'),
('Shatabdi Express', '12001'),
('Rajdhani Express', '12951'),
('Duronto Express', '12213'),
('Garib Rath', '12215');


INSERT INTO train_schedule (train_arrival_time, train_departure_time, train_id, destination_station_id, source_station_id) VALUES
('08:00:00', '08:15:00', 1, 2, 1), -- Deccan Express: Pune to Mumbai
('06:30:00', '06:45:00', 2, 3, 1), -- Shatabdi: Pune to Delhi
('18:00:00', '18:15:00', 3, 5, 3), -- Rajdhani: Delhi to Hyderabad
('20:30:00', '20:50:00', 4, 4, 2), -- Duronto: Mumbai to Bangalore
('10:00:00', '10:15:00', 5, 3, 4); -- Garib Rath: Bangalore to Delhi



INSERT INTO train_stations (station_code, station_name) VALUES
('NDLS', 'New Delhi'),
('BCT', 'Mumbai Central'),
('MAS', 'Chennai Central'),
('SBC', 'Bangalore City Junction'),
('HWH', 'Howrah Junction'),
('SC', 'Secunderabad Junction'),
('ADI', 'Ahmedabad Junction'),
('PNBE', 'Patna Junction'),
('LKO', 'Lucknow Junction'),
('BBS', 'Bhubaneswar');

SELECT * FROM trains 
WHERE source_station = 'Chennai Central' 
  AND destination_station = 'Bangalore City Junction';
  
  
SELECT * FROM train_stations; 


INSERT INTO trains (train_name, train_number) VALUES
('Rajdhani Express', '12951'),
('Shatabdi Express', '12001'),
('Duronto Express', '12213'),
('Garib Rath Express', '12215'),
('Jan Shatabdi Express', '12071'),
('Sampark Kranti Express', '12629'),
('Humsafar Express', '22437'),
('Vande Bharat Express', '22436'),
('Intercity Express', '12127'),
('Superfast Express', '12301'),
('Mail Express', '13005'),
('Antyodaya Express', '22877'),
('Suvidha Express', '82653'),
('Double Decker Express', '12931'),
('Uday Express', '22665'),
('Tejas Express', '22671'),
('Yuva Express', '12249'),
('Tatkal Express', '12345'),
('Holiday Special', '09005'),
('Festival Special', '09301');


INSERT INTO train_schedule (train_arrival_time, train_departure_time, train_id, source_station_id, destination_station_id) VALUES
('06:00:00', '06:15:00', 1, 1, 2),  -- Rajdhani Express: New Delhi to Mumbai
('07:00:00', '07:15:00', 2, 1, 2),  -- Shatabdi Express: New Delhi to Mumbai
('08:00:00', '08:15:00', 3, 1, 2),  -- Duronto Express: New Delhi to Mumbai
('09:00:00', '09:15:00', 4, 1, 2),  -- Garib Rath Express: New Delhi to Mumbai
('10:00:00', '10:15:00', 5, 1, 2),  -- Jan Shatabdi Express: New Delhi to Mumbai
('06:30:00', '06:45:00', 6, 3, 4),  -- Sampark Kranti Express: Chennai to Bangalore
('07:30:00', '07:45:00', 7, 3, 4),  -- Humsafar Express: Chennai to Bangalore
('08:30:00', '08:45:00', 8, 3, 4),  -- Vande Bharat Express: Chennai to Bangalore
('09:30:00', '09:45:00', 9, 3, 4),  -- Intercity Express: Chennai to Bangalore
('10:30:00', '10:45:00', 10, 3, 4), -- Superfast Express: Chennai to Bangalore
('06:15:00', '06:30:00', 11, 5, 6), -- Mail Express: Howrah to Secunderabad
('07:15:00', '07:30:00', 12, 5, 6), -- Antyodaya Express: Howrah to Secunderabad
('08:15:00', '08:30:00', 13, 5, 6), -- Suvidha Express: Howrah to Secunderabad
('09:15:00', '09:30:00', 14, 5, 6), -- Double Decker Express: Howrah to Secunderabad
('10:15:00', '10:30:00', 15, 5, 6), -- Uday Express: Howrah to Secunderabad
('06:45:00', '07:00:00', 16, 7, 8), -- Tejas Express: Ahmedabad to Patna
('07:45:00', '08:00:00', 17, 7, 8), -- Yuva Express: Ahmedabad to Patna
('08:45:00', '09:00:00', 18, 7, 8), -- Tatkal Express: Ahmedabad to Patna
('09:45:00', '10:00:00', 19, 7, 8), -- Holiday Special: Ahmedabad to Patna
('10:45:00', '11:00:00', 20, 7, 8); -- Festival Special: Ahmedabad to Patna



SELECT id, station_name FROM train_stations;

UPDATE train_schedule
SET source_station_id = 8, destination_station_id = 9
WHERE train_id IN (6, 7, 8, 9, 10);  -- Trains starting from Chennai

UPDATE train_schedule
SET source_station_id = 3, destination_station_id = 7
WHERE train_id IN (6, 7, 8, 9, 10);

UPDATE train_schedule
SET source_station_id = 8, destination_station_id = 9
WHERE train_id IN (11, 12, 13, 14, 15);

UPDATE train_schedule
SET source_station_id = 10, destination_station_id = 11
WHERE train_id IN (16, 17, 18, 19, 20);

UPDATE train_schedule
SET source_station_id = 12, destination_station_id = 13
WHERE train_id IN (21, 22, 23, 24, 25);





