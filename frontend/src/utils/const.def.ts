export interface Song {
  id: number;
  title: string;
  composer: string;
  duration: number;
  lyrics: string;
  release_date: string;
  track_number: number;
  album_id: number | null;
  artist_id: number;
  file_url: string;
  image_url: string;
}