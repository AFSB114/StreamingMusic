    -- Creation of tables for a music streaming platform in PostgreSQL

-- ARTIST Table
CREATE TABLE ARTIST (
    artist_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(50),  -- Solo, Band, etc.
    country_of_origin VARCHAR(100),
    debut_date DATE,
    biography TEXT,
    image_url VARCHAR(255)
);

-- GENRE Table
CREATE TABLE GENRE (
    genre_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    parent_genre_id INTEGER REFERENCES GENRE(genre_id) ON DELETE SET NULL
);

-- ARTIST_GENRE Table (bridge table)
CREATE TABLE ARTIST_GENRE (
    artist_id INTEGER NOT NULL,
    genre_id INTEGER NOT NULL,
    PRIMARY KEY (artist_id, genre_id),
    FOREIGN KEY (artist_id) REFERENCES ARTIST(artist_id) ON DELETE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES GENRE(genre_id) ON DELETE CASCADE
);

-- RECORD_LABEL Table
CREATE TABLE RECORD_LABEL (
    record_label_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    country VARCHAR(100),
    foundation_date DATE,
    website VARCHAR(255),
    logo_url VARCHAR(255)
);

-- ALBUM Table
CREATE TABLE ALBUM (
    album_id SERIAL PRIMARY KEY,
    artist_id INTEGER NOT NULL REFERENCES ARTIST(artist_id) ON DELETE CASCADE,
    record_label_id INTEGER REFERENCES RECORD_LABEL(record_label_id) ON DELETE SET NULL,
    title VARCHAR(255) NOT NULL,
    release_date DATE NOT NULL,
    cover_url VARCHAR(255),
    type VARCHAR(50),  -- Studio, Live, Compilation, etc.
    total_duration INTEGER,  -- In seconds
    description TEXT
);

-- SONG Table
CREATE TABLE SONG (
    song_id SERIAL PRIMARY KEY,
    album_id INTEGER REFERENCES ALBUM(album_id) ON DELETE SET NULL,
    artist_id INTEGER NOT NULL REFERENCES ARTIST(artist_id) ON DELETE CASCADE,
    title VARCHAR(255) NOT NULL,
    duration INTEGER NOT NULL,  -- In seconds
    track_number INTEGER,
    release_date DATE,
    composer VARCHAR(255),
    lyrics TEXT,
    file_url VARCHAR(255) NOT NULL
);

-- SONG_GENRE Table (bridge table)
CREATE TABLE SONG_GENRE (
    song_id INTEGER NOT NULL,
    genre_id INTEGER NOT NULL,
    PRIMARY KEY (song_id, genre_id),
    FOREIGN KEY (song_id) REFERENCES SONG(song_id) ON DELETE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES GENRE(genre_id) ON DELETE CASCADE
);

-- USER Table
CREATE TABLE USER_ACCOUNT (
    user_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    registration_date DATE NOT NULL DEFAULT CURRENT_DATE,
    country VARCHAR(100),
    profile_image VARCHAR(255)
);

-- SUBSCRIPTION_PLAN Table
CREATE TABLE SUBSCRIPTION_PLAN (
    plan_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    duration VARCHAR(50) NOT NULL,  -- Monthly, Annual, etc.
    features TEXT,
    audio_quality INTEGER,  -- In kbps
    allows_downloads BOOLEAN DEFAULT FALSE,
    ad_free BOOLEAN DEFAULT FALSE
);

-- SUBSCRIPTION Table
CREATE TABLE SUBSCRIPTION (
    subscription_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES USER_ACCOUNT(user_id) ON DELETE CASCADE,
    plan_id INTEGER NOT NULL REFERENCES SUBSCRIPTION_PLAN(plan_id) ON DELETE RESTRICT,
    start_date DATE NOT NULL DEFAULT CURRENT_DATE,
    renewal_date DATE NOT NULL,
    status VARCHAR(50) NOT NULL,  -- Active, Cancelled, etc.
    payment_method VARCHAR(100)
);

-- PLAYLIST Table
CREATE TABLE PLAYLIST (
    playlist_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES USER_ACCOUNT(user_id) ON DELETE CASCADE,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    creation_date DATE NOT NULL DEFAULT CURRENT_DATE,
    is_public BOOLEAN DEFAULT TRUE,
    image_url VARCHAR(255)
);

-- PLAYLIST_SONG Table (bridge table)
CREATE TABLE PLAYLIST_SONG (
    playlist_id INTEGER NOT NULL,
    song_id INTEGER NOT NULL,
    position INTEGER NOT NULL,
    date_added TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (playlist_id, song_id),
    FOREIGN KEY (playlist_id) REFERENCES PLAYLIST(playlist_id) ON DELETE CASCADE,
    FOREIGN KEY (song_id) REFERENCES SONG(song_id) ON DELETE CASCADE
);

-- PLAYBACK Table
CREATE TABLE PLAYBACK (
    playback_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES USER_ACCOUNT(user_id) ON DELETE CASCADE,
    song_id INTEGER NOT NULL REFERENCES SONG(song_id) ON DELETE CASCADE,
    date_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    listened_duration INTEGER,  -- In seconds
    device VARCHAR(100),
    location VARCHAR(255)
);

-- FAVORITE Table
CREATE TABLE FAVORITE (
    favorite_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES USER_ACCOUNT(user_id) ON DELETE CASCADE,
    object_type VARCHAR(50) NOT NULL,  -- 'song', 'album', 'artist', 'playlist'
    object_id INTEGER NOT NULL,
    date_marked TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (user_id, object_type, object_id)
);

-- Indexes to improve performance

-- Indexes for frequent searches
CREATE INDEX idx_song_title ON SONG(title);
CREATE INDEX idx_album_title ON ALBUM(title);
CREATE INDEX idx_artist_name ON ARTIST(name);

-- Indexes for foreign keys
CREATE INDEX idx_album_artist ON ALBUM(artist_id);
CREATE INDEX idx_song_album ON SONG(album_id);
CREATE INDEX idx_song_artist ON SONG(artist_id);

-- Indexes for playback analysis
CREATE INDEX idx_playback_song ON PLAYBACK(song_id);
CREATE INDEX idx_playback_user ON PLAYBACK(user_id);
CREATE INDEX idx_playback_date ON PLAYBACK(date_time);

-- Indexes for playlist management
CREATE INDEX idx_playlist_user ON PLAYLIST(user_id);
CREATE INDEX idx_playlist_public ON PLAYLIST(is_public);

-- Indexes for subscriptions
CREATE INDEX idx_subscription_user ON SUBSCRIPTION(user_id);
CREATE INDEX idx_subscription_status ON SUBSCRIPTION(status);