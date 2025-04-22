
create table users
(
user_id int primary key auto_increment,
name varchar(30),
email varchar(30),
phone varchar(30)
);

create table movies
(
movie_id int primary key auto_increment,
title varchar(30),
genere varchar(30),
lang varchar(30),
duration int 
);

create table theatre
(
t_id int primary key auto_increment,
name varchar(30),
city varchar(30)
);

create table shows
(
show_id int primary key auto_increment,
movie_id int,
t_id int,
timing varchar(30),
available_seat int,
foreign key (movie_id) references movies(movie_id),
foreign key (t_id) references theatre(t_id)
);

create table seat
(
seat_id int primary key auto_increment,
show_id int,
seat_number varchar(30),
is_booked boolean default false,
foreign key (show_id) references shows(show_id)
);

create table bookings
(
booking_id int primary key auto_increment,
user_id int,
show_id int,
seats_booked varchar(30),
total_price decimal(10,2)
);

INSERT INTO users (name, email, phone) VALUES
('Aarav', 'aarav99@xyz.com', '9898989898'),
('Diya', 'diya.k@xyz.com', '9876543211'),
('Ishaan', 'ishaan_123@xyz.com', '9765432190'),
('Riya', 'riya.riya@xyz.com', '9123456780'),
('Kabir', 'kabir.kb@xyz.com', '9090909090'),
('Mira', 'mira_m@xyz.com', '9876100011'),
('Tanish', 'tanish@xyz.com', '9865321470'),
('Anaya', 'anaya@xyz.com', '9988776655'),
('Vivaan', 'vivaan@xyz.com', '9654123087'),
('Saanvi', 'saanvi@xyz.com', '9876543200'),
('Arjun', 'arjun.d@xyz.com', '9632587410'),
('Meera', 'meera.lov@xyz.com', '9745632109'),
('Krish', 'krish.k@xyz.com', '9654321987'),
('Avni', 'avni@xyz.com', '9123678945'),
('Yuvraj', 'yuvraj@xyz.com', '9678098765'),
('Pihu', 'pihu@xyz.com', '9761234567');

select * from users;


INSERT INTO movies (title, genere, lang, duration) VALUES
('Zindagi Na Milegi Dobara', 'Drama', 'Hindi', 155),
('Dangal', 'Biography', 'Hindi', 160),
('Baahubali', 'Action', 'Telugu', 170),
('Interstellar', 'Sci-Fi', 'English', 169),
('Inception', 'Thriller', 'English', 148),
('3 Idiots', 'Comedy', 'Hindi', 172),
('Titanic', 'Romantic', 'English', 195),
('Avengers: Endgame', 'Action', 'English', 181),
('The Dark Knight', 'Thriller', 'English', 152),
('Coco', 'Animation', 'English', 105),
('Jawan', 'Action', 'Hindi', 169),
('OMG 2', 'Drama', 'Hindi', 138),
('Sita Ramam', 'Romantic', 'Telugu', 156),
('Pathaan', 'Action', 'Hindi', 147),
('Oppenheimer', 'History', 'English', 180),
('Rocky Aur Rani', 'Romantic', 'Hindi', 160);

select * from movies;


INSERT INTO theatre (name, city) VALUES
('INOX', 'Mumbai'),
('INOX', 'Delhi'),
('PVR', 'Delhi'),
('PVR', 'Hyderabad'),
('CityPride', 'Pune'),
('Carnival', 'Pune'),
('IMAX', 'Bangalore'),
('PVR', 'Bangalore'),
('PVR', 'Chennai'),
('INOX', 'Chennai'),
('Rajhans', 'Surat'),
('Gold Cinema', 'Nashik'),
('Miraj', 'Aurangabad'),
('Lotus', 'Nagpur'),
('Fun Cinemas', 'Kolkata');


INSERT INTO shows (movie_id, t_id, timing, available_seat) VALUES
(7, 6, '10:00 AM', 50),
(8, 7, '01:00 PM', 50),
(9, 8, '03:00 PM', 45),
(10, 9, '05:00 PM', 40),
(11, 10, '07:00 PM', 50),
(12, 11, '09:00 AM', 48),
(13, 12, '11:30 AM', 42),
(14, 13, '02:30 PM', 44),
(15, 14, '06:00 PM', 49),
(16, 15, '08:30 PM', 50),
(17, 16, '09:30 PM', 47),
(18, 17, '03:00 PM', 41),
(19, 18, '11:00 AM', 50),
(20, 19, '06:30 PM', 38),
(21, 20, '01:30 PM', 40),
(22, 6, '04:00 PM', 46);


insert into seat (show_id,seat_number , is_booked) values
(1,"A1" , FALSE), (1,"A2" , FALSE),(1,"A3" , FALSE),(1,"A4" , FALSE),(1,"A4" , FALSE),(1,"A5" , FALSE),
(2,"B1" , FALSE), (2,"B2" , FALSE),(2,"B3" , FALSE),(2,"B4" , FALSE),(2,"B4" , FALSE),(2,"B5" , FALSE),
(3,"C1" , FALSE), (3,"C2" , FALSE),(3,"C3" , FALSE),(3,"C4" , FALSE),(3,"C4" , FALSE),(3,"C5" , FALSE),
(4,"D1" , FALSE), (4,"D2" , FALSE),(4,"D3" , FALSE),(4,"D4" , FALSE),(4,"D4" , FALSE),(4,"D5" , FALSE),
(5,"E1" , FALSE), (5,"E2" , FALSE),(5,"E3" , FALSE),(5,"E4" , FALSE),(5,"E4" , FALSE),(5,"E5" , FALSE),
(6, 'A1', FALSE), (6, 'A2', FALSE), (6, 'A3', FALSE),
(7, 'B1', FALSE), (7, 'B2', FALSE), (7, 'B3', FALSE),
(8, 'C1', FALSE), (8, 'C2', FALSE), (8, 'C3', FALSE),
(9, 'D1', FALSE), (9, 'D2', FALSE), (9, 'D3', FALSE),
(10, 'E1', FALSE), (10, 'E2', FALSE), (10, 'E3', FALSE),
(11, 'F1', FALSE), (11, 'F2', FALSE), (11, 'F3', FALSE),
(12, 'G1', FALSE), (12, 'G2', FALSE), (12, 'G3', FALSE),
(13, 'H1', FALSE), (13, 'H2', FALSE), (13, 'H3', FALSE),
(14, 'I1', FALSE), (14, 'I2', FALSE), (14, 'I3', FALSE),
(15, 'J1', FALSE), (15, 'J2', FALSE), (15, 'J3', FALSE),
(16, 'K1', FALSE), (16, 'K2', FALSE), (16, 'K3', FALSE),
(17, 'L1', FALSE), (17, 'L2', FALSE), (17, 'L3', FALSE),
(18, 'M1', FALSE), (18, 'M2', FALSE), (18, 'M3', FALSE),
(19, 'N1', FALSE), (19, 'N2', FALSE), (19, 'N3', FALSE),
(20, 'O1', FALSE), (20, 'O2', FALSE), (20, 'O3', FALSE),
(21, 'P1', FALSE), (21, 'P2', FALSE), (21, 'P3', FALSE),
(22, 'Q1', FALSE), (22, 'Q2', FALSE), (22, 'Q3', FALSE);


INSERT INTO bookings (user_id, show_id, seats_booked, total_price) VALUES
(1, 1, 'A1,A2', 400),
(2, 2, 'B1', 200),
(3, 3, 'C1,C2,C3', 600),
(4, 4, 'D1,D2', 400),
(5, 5, 'E1', 200),
(6, 6, 'F1,F2', 400),
(7, 7, 'G1', 200),
(8, 8, 'H1,H2,H3,H4', 800),
(9, 9, 'I1,I2', 400),
(10, 10, 'J1', 200),
(11, 11, 'K1,K2', 400),
(12, 12, 'L1', 200),
(13, 13, 'M1,M2,M3', 600),
(14, 14, 'N1', 200),
(15, 15, 'O1,O2', 400),
(16, 16, 'P1,P2,P3', 600),
(1, 17, 'Q1,Q2', 400),
(2, 18, 'R1', 200),
(3, 19, 'S1,S2,S3', 600),
(4, 20, 'T1', 200);


UPDATE seat SET is_booked = TRUE WHERE 
(show_id = 1 AND seat_number IN ('A1','A2')) OR
(show_id = 2 AND seat_number IN ('B1')) OR
(show_id = 3 AND seat_number IN ('C1','C2','C3')) OR
(show_id = 4 AND seat_number IN ('D1','D2')) OR
(show_id = 5 AND seat_number IN ('E1')) OR
(show_id = 6 AND seat_number IN ('F1','F2')) OR
(show_id = 7 AND seat_number IN ('G1')) OR
(show_id = 8 AND seat_number IN ('H1','H2','H3','H4')) OR
(show_id = 9 AND seat_number IN ('I1','I2')) OR
(show_id = 10 AND seat_number IN ('J1')) OR
(show_id = 11 AND seat_number IN ('K1','K2')) OR
(show_id = 12 AND seat_number IN ('L1')) OR
(show_id = 13 AND seat_number IN ('M1','M2','M3')) OR
(show_id = 14 AND seat_number IN ('N1')) OR
(show_id = 15 AND seat_number IN ('O1','O2')) OR
(show_id = 16 AND seat_number IN ('P1','P2','P3')) OR
(show_id = 17 AND seat_number IN ('Q1','Q2')) OR
(show_id = 18 AND seat_number IN ('R1')) OR
(show_id = 19 AND seat_number IN ('S1','S2','S3')) OR
(show_id = 20 AND seat_number IN ('T1'));


select * from bookings;

select * from seat;








