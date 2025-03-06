-- Sample data for ARTIST table
INSERT INTO ARTIST (name, type, country_of_origin, debut_date, biography, image_url) VALUES
('Taylor Swift', 'Solo', 'United States', '2006-10-24', 'American singer-songwriter known for narrative songs about her personal life.', 'https://example.com/images/taylor_swift.jpg'),
('Queen', 'Band', 'United Kingdom', '1970-06-27', 'British rock band formed in London in 1970, known for their highly theatrical style.', 'https://example.com/images/queen.jpg'),
('Bad Bunny', 'Solo', 'Puerto Rico', '2016-05-05', 'Puerto Rican rapper and singer who rose to prominence in 2016.', 'https://example.com/images/bad_bunny.jpg'),
('Daft Punk', 'Band', 'France', '1993-09-17', 'French electronic music duo formed in Paris in 1993.', 'https://example.com/images/daft_punk.jpg'),
('Adele', 'Solo', 'United Kingdom', '2008-01-28', 'English singer-songwriter known for her powerful voice and emotional ballads.', 'https://example.com/images/adele.jpg');

-- Sample data for GENRE table
INSERT INTO GENRE (genre_id, name, description, parent_genre_id) VALUES
(1, 'Pop', 'Contemporary popular music', NULL),
(2, 'Rock', 'Music characterized by a strong beat and simple melodies', NULL),
(3, 'Hip Hop', 'Style of popular music with rhythmic vocals, often accompanied by backing beats', NULL),
(4, 'Electronic', 'Music that employs electronic musical instruments and technology', NULL),
(5, 'Latin', 'Music originating from Latin American countries', NULL),
(6, 'Indie Pop', 'Pop music produced independently from commercial record labels', 1),
(7, 'Alternative Rock', 'Rock music produced outside or parallel to the mainstream', 2),
(8, 'Trap', 'Hip hop subgenre that originated in the Southern United States', 3),
(9, 'House', 'Electronic dance music genre characterized by repetitive 4/4 beats', 4),
(10, 'Reggaeton', 'Music genre that originated in Puerto Rico', 5);

-- Sample data for ARTIST_GENRE bridge table
INSERT INTO ARTIST_GENRE (artist_id, genre_id) VALUES
(1, 1), -- Taylor Swift - Pop
(1, 6), -- Taylor Swift - Indie Pop
(2, 2), -- Queen - Rock
(2, 7), -- Queen - Alternative Rock
(3, 3), -- Bad Bunny - Hip Hop
(3, 8), -- Bad Bunny - Trap
(3, 10), -- Bad Bunny - Reggaeton
(4, 4), -- Daft Punk - Electronic
(4, 9), -- Daft Punk - House
(5, 1); -- Adele - Pop

-- Sample data for RECORD_LABEL table
INSERT INTO RECORD_LABEL (name, country, foundation_date, website, logo_url) VALUES
('Republic Records', 'United States', '1995-01-01', 'https://republicrecords.com', 'https://example.com/logos/republic.jpg'),
('EMI', 'United Kingdom', '1931-03-01', 'https://emimusic.com', 'https://example.com/logos/emi.jpg'),
('Rimas Entertainment', 'Puerto Rico', '2014-06-15', 'https://rimasentertainment.com', 'https://example.com/logos/rimas.jpg'),
('Columbia Records', 'United States', '1887-01-15', 'https://columbiarecords.com', 'https://example.com/logos/columbia.jpg'),
('XL Recordings', 'United Kingdom', '1989-01-01', 'https://xlrecordings.com', 'https://example.com/logos/xl.jpg');

-- Sample data for ALBUM table
INSERT INTO ALBUM (artist_id, record_label_id, title, release_date, cover_url, type, total_duration, description) VALUES
(1, 1, 'Folklore', '2020-07-24', 'https://example.com/covers/folklore.jpg', 'Studio', 3840, 'Eighth studio album by Taylor Swift, featuring indie folk and alternative rock'),
(2, 2, 'A Night at the Opera', '1975-11-21', 'https://example.com/covers/night_at_the_opera.jpg', 'Studio', 2539, 'Fourth studio album by Queen, featuring Bohemian Rhapsody'),
(3, 3, 'YHLQMDLG', '2020-02-29', 'https://example.com/covers/yhlqmdlg.jpg', 'Studio', 4140, 'Second studio album by Bad Bunny, whose title stands for "Yo Hago Lo Que Me Da La Gana"'),
(4, 4, 'Random Access Memories', '2013-05-17', 'https://example.com/covers/random_access_memories.jpg', 'Studio', 4458, 'Fourth studio album by Daft Punk, featuring Get Lucky'),
(5, 5, '25', '2015-11-20', 'https://example.com/covers/25.jpg', 'Studio', 2880, 'Third studio album by Adele, featuring Hello');

-- Sample data for SONG table
INSERT INTO SONG (album_id, artist_id, title, duration, track_number, release_date, composer, lyrics, file_url) VALUES
(1, 1, 'Cardigan', 239, 1, '2020-07-24', 'Taylor Swift, Aaron Dessner', 'And when I felt like I was an old cardigan under someone''s bed...', 'https://example.com/songs/cardigan.mp3'),
(1, 1, 'The Last Great American Dynasty', 231, 2, '2020-07-24', 'Taylor Swift, Aaron Dessner', 'Rebekah rode up on the afternoon train, it was sunny...', 'https://example.com/songs/the_last_great_american_dynasty.mp3'),
(2, 2, 'Bohemian Rhapsody', 354, 11, '1975-10-31', 'Freddie Mercury', 'Is this the real life? Is this just fantasy?...', 'https://example.com/songs/bohemian_rhapsody.mp3'),
(2, 2, 'Love of My Life', 217, 9, '1975-11-21', 'Freddie Mercury', 'Love of my life, you''ve hurt me...', 'https://example.com/songs/love_of_my_life.mp3'),
(3, 3, 'La Difícil', 171, 2, '2020-02-29', 'Bad Bunny', 'Ahora me busca, ey, ahora me llama...', 'https://example.com/songs/la_dificil.mp3'),
(3, 3, 'Yo Perreo Sola', 172, 7, '2020-03-27', 'Bad Bunny', 'Antes tú me pichaba (Tú me pichaba)...', 'https://example.com/songs/yo_perreo_sola.mp3'),
(4, 4, 'Get Lucky', 367, 8, '2013-04-19', 'Thomas Bangalter, Guy-Manuel de Homem-Christo, Pharrell Williams, Nile Rodgers', 'Like the legend of the phoenix...', 'https://example.com/songs/get_lucky.mp3'),
(4, 4, 'Instant Crush', 337, 5, '2013-05-17', 'Thomas Bangalter, Guy-Manuel de Homem-Christo, Julian Casablancas', 'I didn''t want to be the one to forget...', 'https://example.com/songs/instant_crush.mp3'),
(5, 5, 'Hello', 295, 1, '2015-10-23', 'Adele Adkins, Greg Kurstin', 'Hello, it''s me, I was wondering if after all these years...', 'https://example.com/songs/hello.mp3'),
(5, 5, 'When We Were Young', 290, 4, '2016-01-22', 'Adele Adkins, Tobias Jesso Jr.', 'Everybody loves the things you do...', 'https://example.com/songs/when_we_were_young.mp3');

-- Sample data for SONG_GENRE bridge table
INSERT INTO SONG_GENRE (song_id, genre_id) VALUES
(1, 1), -- Cardigan - Pop
(1, 6), -- Cardigan - Indie Pop
(2, 1), -- The Last Great American Dynasty - Pop
(2, 6), -- The Last Great American Dynasty - Indie Pop
(3, 2), -- Bohemian Rhapsody - Rock
(3, 7), -- Bohemian Rhapsody - Alternative Rock
(4, 2), -- Love of My Life - Rock
(5, 3), -- La Difícil - Hip Hop
(5, 10), -- La Difícil - Reggaeton
(6, 3), -- Yo Perreo Sola - Hip Hop
(6, 10), -- Yo Perreo Sola - Reggaeton
(7, 4), -- Get Lucky - Electronic
(7, 9), -- Get Lucky - House
(8, 4), -- Instant Crush - Electronic
(9, 1), -- Hello - Pop
(10, 1); -- When We Were Young - Pop

-- Sample data for USER_ACCOUNT table
INSERT INTO USER_ACCOUNT (name, email, password, registration_date, country, profile_image) VALUES
('John Smith', 'john.smith@example.com', 'hashed_password_1', '2023-01-15', 'United States', 'https://example.com/profiles/john_smith.jpg'),
('Maria Garcia', 'maria.garcia@example.com', 'hashed_password_2', '2023-02-20', 'Spain', 'https://example.com/profiles/maria_garcia.jpg'),
('Raj Patel', 'raj.patel@example.com', 'hashed_password_3', '2023-03-10', 'India', 'https://example.com/profiles/raj_patel.jpg'),
('Emma Wilson', 'emma.wilson@example.com', 'hashed_password_4', '2023-04-05', 'Canada', 'https://example.com/profiles/emma_wilson.jpg'),
('Chen Wei', 'chen.wei@example.com', 'hashed_password_5', '2023-05-12', 'China', 'https://example.com/profiles/chen_wei.jpg');

-- Sample data for SUBSCRIPTION_PLAN table
INSERT INTO SUBSCRIPTION_PLAN (name, price, duration, features, audio_quality, allows_downloads, ad_free) VALUES
('Free', 0.00, 'Unlimited', 'Basic streaming with ads', 128, FALSE, FALSE),
('Individual', 9.99, 'Monthly', 'Ad-free music listening, download to listen offline', 320, TRUE, TRUE),
('Family', 14.99, 'Monthly', 'Ad-free music for up to 6 accounts, download to listen offline', 320, TRUE, TRUE),
('Student', 4.99, 'Monthly', 'Ad-free music listening at a discounted rate, download to listen offline', 320, TRUE, TRUE),
('Premium Annual', 99.99, 'Annual', 'Ad-free music listening with annual discount, download to listen offline', 320, TRUE, TRUE);

-- Sample data for SUBSCRIPTION table
INSERT INTO SUBSCRIPTION (user_id, plan_id, start_date, renewal_date, status, payment_method) VALUES
(1, 2, '2023-01-15', '2023-02-15', 'Active', 'Credit Card'),
(2, 3, '2023-02-20', '2023-03-20', 'Active', 'PayPal'),
(3, 1, '2023-03-10', '2023-04-10', 'Active', NULL),
(4, 4, '2023-04-05', '2023-05-05', 'Active', 'Debit Card'),
(5, 5, '2023-05-12', '2024-05-12', 'Active', 'Credit Card');

-- Sample data for PLAYLIST table
INSERT INTO PLAYLIST (user_id, name, description, creation_date, is_public, image_url) VALUES
(1, 'Workout Mix', 'High energy songs for the gym', '2023-01-20', TRUE, 'https://example.com/playlists/workout_mix.jpg'),
(1, 'Chill Vibes', 'Relaxing songs for the evening', '2023-01-25', TRUE, 'https://example.com/playlists/chill_vibes.jpg'),
(2, 'Road Trip', 'Songs for the long drive', '2023-02-22', TRUE, 'https://example.com/playlists/road_trip.jpg'),
(3, 'Study Session', 'Focus music for studying', '2023-03-15', FALSE, 'https://example.com/playlists/study_session.jpg'),
(4, 'Party Anthems', 'Songs to get the party started', '2023-04-10', TRUE, 'https://example.com/playlists/party_anthems.jpg');

-- Sample data for PLAYLIST_SONG bridge table
INSERT INTO PLAYLIST_SONG (playlist_id, song_id, position, date_added) VALUES
(1, 7, 1, '2023-01-20 14:30:00'), -- Workout Mix - Get Lucky
(1, 6, 2, '2023-01-20 14:32:00'), -- Workout Mix - Yo Perreo Sola
(1, 3, 3, '2023-01-21 09:15:00'), -- Workout Mix - Bohemian Rhapsody
(2, 1, 1, '2023-01-25 20:10:00'), -- Chill Vibes - Cardigan
(2, 4, 2, '2023-01-25 20:12:00'), -- Chill Vibes - Love of My Life
(2, 9, 3, '2023-01-26 21:05:00'), -- Chill Vibes - Hello
(3, 3, 1, '2023-02-22 12:40:00'), -- Road Trip - Bohemian Rhapsody
(3, 7, 2, '2023-02-22 12:42:00'), -- Road Trip - Get Lucky
(3, 9, 3, '2023-02-23 08:20:00'), -- Road Trip - Hello
(4, 2, 1, '2023-03-15 18:30:00'), -- Study Session - The Last Great American Dynasty
(4, 8, 2, '2023-03-15 18:33:00'), -- Study Session - Instant Crush
(5, 6, 1, '2023-04-10 19:20:00'), -- Party Anthems - Yo Perreo Sola
(5, 7, 2, '2023-04-10 19:22:00'); -- Party Anthems - Get Lucky

-- Sample data for PLAYBACK table
INSERT INTO PLAYBACK (user_id, song_id, date_time, listened_duration, device, location) VALUES
(1, 1, '2023-01-21 10:15:00', 239, 'iPhone', 'New York, USA'),
(1, 3, '2023-01-21 10:20:00', 354, 'iPhone', 'New York, USA'),
(2, 6, '2023-02-25 15:30:00', 172, 'Android Phone', 'Madrid, Spain'),
(2, 7, '2023-02-25 15:35:00', 367, 'Android Phone', 'Madrid, Spain'),
(3, 9, '2023-03-18 20:45:00', 295, 'Web Browser', 'Mumbai, India'),
(3, 10, '2023-03-18 20:50:00', 290, 'Web Browser', 'Mumbai, India'),
(4, 2, '2023-04-12 08:10:00', 231, 'iPad', 'Toronto, Canada'),
(4, 4, '2023-04-12 08:15:00', 217, 'iPad', 'Toronto, Canada'),
(5, 5, '2023-05-15 19:20:00', 171, 'Android Tablet', 'Beijing, China'),
(5, 8, '2023-05-15 19:25:00', 337, 'Android Tablet', 'Beijing, China');

-- Sample data for FAVORITE table
INSERT INTO FAVORITE (user_id, object_type, object_id, date_marked) VALUES
(1, 'song', 3, '2023-01-22 11:30:00'), -- John likes Bohemian Rhapsody
(1, 'artist', 2, '2023-01-22 11:35:00'), -- John likes Queen
(2, 'song', 6, '2023-02-26 16:45:00'), -- Maria likes Yo Perreo Sola
(2, 'album', 3, '2023-02-26 16:50:00'), -- Maria likes YHLQMDLG
(3, 'song', 9, '2023-03-19 21:10:00'), -- Raj likes Hello
(3, 'artist', 5, '2023-03-19 21:15:00'), -- Raj likes Adele
(4, 'song', 2, '2023-04-13 09:25:00'), -- Emma likes The Last Great American Dynasty
(4, 'album', 1, '2023-04-13 09:30:00'), -- Emma likes Folklore
(5, 'song', 7, '2023-05-16 20:10:00'), -- Chen likes Get Lucky
(5, 'artist', 4, '2023-05-16 20:15:00'); -- Chen likes Daft Punk