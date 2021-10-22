/*Drop all tables*/
DROP TABLE Users, Playlists, Songs, Movies

/*Recreate tables for testdatabase*/
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

