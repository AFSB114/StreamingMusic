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

export interface MusicContextType {
  musics: Song[];
  setMusics: React.Dispatch<React.SetStateAction<Song[]>>;
  deleteMusic: (id: number) => void;
  getMusicById: (id: number) => Song | null;
  updateMusic: (id: number, updatedSong: Partial<Song>) => void;
  addMusic: (newSong: Omit<Song, 'id'>) => number;
}

interface Link {
  name: string;
  href: string;
}

export const links: Link[] = [
  { name: "Home", href: "/" },
  { name: "Songs", href: "/songs" },
  { name: "Albums", href: "/albums" },
  { name: "Artists", href: "/artists" },
  { name: "Playlists", href: "/playlists" },
];
