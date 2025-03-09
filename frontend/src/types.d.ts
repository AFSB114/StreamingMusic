export type EntityAction<T> =
  | { type: "ADD"; payload: Omit<T, "id"> }
  | { type: "DELETE"; payload: number }
  | { type: "UPDATE"; payload: { id: number; updatedEntity: Partial<T> } };

export interface songType {
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

export interface SongContextType {
  songsList: songType[];
  setSongsList: React.Dispatch<React.SetStateAction<songType[]>>;
  deleteSong: (id: number) => void;
  getSongById: (id: number) => songType | null;
  updateSongsList: (id: number, updatedSong: Partial<songType>) => void;
  addSong: (newSong: Omit<songType, "id">) => number;
}

export interface ArtistType {
  id: number;
  name: string;
  biography: string;
  country_of_origin: string;
  debut_date: string;
  image_url: string;
  type: string;
}

export interface ArtistContextType {
  artists: ArtistType[];
  setArtists: React.Dispatch<React.SetStateAction<ArtistType[]>>;
  deleteArtist: (id: number) => void;
  getArtistById: (id: number) => ArtistType | null;
  updateArtist: (id: number, updatedArtist: Partial<ArtistType>) => void;
  addArtist: (newArtist: Omit<ArtistType, "id">) => number;
}

export interface LinkType {
  name: string;
  href: string;
}
