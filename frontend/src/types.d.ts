export type EntityAction<T> =
  | { type: "ADD"; payload: Omit<T, "id"> }
  | { type: "DELETE"; payload: number }
  | { type: "UPDATE"; payload: { id: number; updatedEntity: Partial<T> } };

// Definimos una interfaz base que requiere un campo 'id'
export interface EntityWithId {
  id: number;
}

export interface SongType {
  id: number;
  title: string;
  composer: string;
  duration: number;
  lyrics: string;
  release_date: string;
  track_number: number;
  album_id: number | null
  artist_id: number;
  file_url: string;
  image_url: string;
}

export interface SongContextType {
  songsList: SongType[];
  deleteSong: (id: number) => void;
  getSongById: (id: number) => SongType | null;
  updateSongsList: (id: number, updatedSong: Partial<SongType>) => void;
  addSong: (newSong: Omit<SongType, "id">) => void;
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
  artistsList: ArtistType[];
  deleteArtist: (id: number) => void;
  getArtistById: (id: number) => ArtistType | null;
  updateArtistsList: (id: number, updatedArtist: Partial<ArtistType>) => void;
  addArtist: (newArtist: Omit<ArtistType, "id">) => void;
}

export interface LinkType {
  name: string;
  href: string;
}
