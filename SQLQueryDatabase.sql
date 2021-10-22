CREATE TABLE Users (
    userID int PRIMARY KEY IDENTITY(0,1),
    userName varChar(255),
    password varChar(2555),
);

CREATE TABLE Playlists (
    playlistID int PRIMARY KEY IDENTITY(0,1) NOT NULL,
    name varChar(255) NOT NULL,
    ownerID int NOT NULL,
);

CREATE TABLE Songs (
    ID int PRIMARY KEY IDENTITY(0,1) NOT NULL,
    playlistID int NOT NULL,
    name varChar(255) NOT NULL,
	performer varChar(255),
	url varChar(255),
	length int NOT NULL,
	album varChar(255),
	playcount int,
	offline BIT
	);

CREATE TABLE Movies (
    ID int PRIMARY KEY IDENTITY(0,1) NOT NULL,
    playlistID int NOT NULL,
    name varChar(255) NOT NULL,
	performer varChar(255),
	url varChar(255),
	length int NOT NULL,
	publicDate varChar(255),
	description varChar(2555),
	playcount int,
	offline BIT
);

DROP TABLE Playlists
DROP TABLE Songs
DROP TABLE Movies

SELECT * FROM Users

SELECT * FROM Playlists

SELECT * FROM Songs
SELECT * FROM Movies

DELETE FROM Songs WHERE ID >= 15

DELETE * FROM Playlists WHERE playlistID = ?
SELECT * FROM Playlists WHERE ownerID = ?

UPDATE Users SET password = '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8' where password = 'password'

INSERT INTO Users (userName, password)
VALUES ('userA', 'password'), ('userB', 'password')

INSERT INTO Playlists (name, ownerID)
VALUES ('Good_Music', 0), ('NOT_GOOD_MUSIC', 0)


INSERT INTO Songs (playlistID, name, performer, url, length, album, playcount, offline)
VALUES (1, 'SongA', 'PerformerA', 'url.com', 3212, 'AlbumA', 2, 0),
       (1, 'SongB', 'PerformerB', 'url.com', 3212, 'AlbumS', 2, 1),
       (1, 'SongC', 'PerformerA', 'url.com', 3212, 'AlbumA', 2, 0)

INSERT INTO Movies (playlistID, name, performer, url, length, publicDate, description, playcount, offline)
VALUES (1, 'MovieA', 'PerformerA', 'url.com', 3212, '1-1-1', 'Very good', 0, 0),
       (1, 'MovieB', 'PerformerA', 'url.com', 3212, '1-1-1', 'Not very good', 0, 0),
       (1, 'MovieC', 'PerformerA', 'url.com', 3212, '1-1-1', 'Good', 0, 0)

INSERT INTO Songs (playlistID, name, performer, url, length, album, playcount, offline)
VALUES (0, 'SongA', 'PerformerA', 'url.com', 3212, 'AlbumA', 2, 0),
       (0, 'SongB', 'PerformerB', 'url.com', 3212, 'AlbumS', 2, 1),
       (0, 'SongC', 'PerformerA', 'url.com', 3212, 'AlbumA', 2, 1),
    (0, 'SongA', 'PerformerA', 'url.com', 3212, 'AlbumA', 2, 0),
       (0, 'SongB', 'PerformerB', 'url.com', 3212, 'AlbumS', 2, 1),
       (0, 'SongC', 'PerformerA', 'url.com', 3212, 'AlbumA', 2, 1),
(0, 'SongA', 'PerformerA', 'url.com', 3212, 'AlbumA', 2, 0),
       (0, 'SongB', 'PerformerB', 'url.com', 3212, 'AlbumS', 2, 1),
       (0, 'SongC', 'PerformerA', 'url.com', 3212, 'AlbumA', 2, 1)

INSERT INTO Movies (playlistID, name, performer, url, length, publicDate, description, playcount, offline)
VALUES (0, 'MovieA', 'PerformerA', 'url.com', 3212, '1-1-1', 'Very good', 0, 1),
       (0, 'MovieB', 'PerformerA', 'url.com', 3212, '1-1-1', 'Not very good', 0, 0),
       (0, 'MovieC', 'PerformerA', 'url.com', 3212, '1-1-1', 'Good', 0, 1),
    (0, 'MovieA', 'PerformerA', 'url.com', 3212, '1-1-1', 'Very good', 0, 1),
       (0, 'MovieB', 'PerformerA', 'url.com', 3212, '1-1-1', 'Not very good', 0, 0),
       (0, 'MovieC', 'PerformerA', 'url.com', 3212, '1-1-1', 'Good', 0, 1),
(0, 'MovieA', 'PerformerA', 'url.com', 3212, '1-1-1', 'Very good', 0, 1),
       (0, 'MovieB', 'PerformerA', 'url.com', 3212, '1-1-1', 'Not very good', 0, 0),
       (0, 'MovieC', 'PerformerA', 'url.com', 3212, '1-1-1', 'Good', 0, 1)