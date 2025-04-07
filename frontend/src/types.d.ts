export type EntityAction<T> =
  | { type: "GET"; payload: T[] }
  | { type: "ADD"; payload: Response<T> }
  | { type: "UPDATE"; payload: { id: number; updatedEntity: Response<T> } }
  | { type: "DELETE"; payload: number }
  | { type: "SEARCH"; payload: Response<T> };

export interface Response<T> {
  httpStatus: string;
  message: string;
  ok: boolean;
  errors: string[];
  data: T[];
}

export interface ArtistType {
  id: number;
  name: string;
  biography: string | null;
  countryOfOrigin: string | null;
  debutDate: string | null;
  imageUrl: string | null;
  type: string | null;
}

export interface ArtistContextType {
  artistsList: ArtistType[];
  addArtist: (newArtist: Omit<ArtistType, "id">) => void;
  deleteArtist: (id: number) => void;
  getArtistById: (id: number) => ArtistType | null;
  updateArtist: (id: number, updatedArtist: Partial<ArtistType>) => void;
  searchArtists: (params: Record<string, string>) => void;
}

export interface ArtistParams {
  name: string;
  type: unknown;
}

export interface RecordLabelType {
  id: number;
  name: string;
  country: string | null;
  foundationDate: string | null;
  website: string | null;
  logoUrl: string | null;
}

export interface RecordLabelContextType {
  recordLabelsList: RecordLabelType[];
  addRecordLabel: (newRecordLabel: Omit<RecordLabelType, "id">) => void;
  deleteRecordLabel: (id: number) => void;
  getRecordLabelById: (id: number) => RecordLabelType | null;
  updateRecordLabel: (
    id: number,
    updatedRecordLabel: Partial<RecordLabelType>
  ) => void;
  searchRecordLabels: (params: Record<string, string>) => void;
}

export interface RecordLabelParams {
  name: string;
  country: string;
}

export interface AlbumType {
  id: number;
  title: string;
  releaseDate: string;
  trackNumber: number;
  totalDuration: number;
  description: string;
  recordLabelName: string;
  imageUrl: string;
  artistId: number;
}

export interface SongType {
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
  songsList: SongType[];
  addSong: (newSong: Omit<SongType, "id">) => void;
  deleteSong: (id: number) => void;
  getSongById: (id: number) => SongType | null;
  updateSongsList: (id: number, updatedSong: Partial<SongType>) => Response;
}

export interface LinkType {
  name: string;
  href: string;
}

export interface DropdownItem {
  label: string;
  value: string | number;
  disabled?: boolean;
}

export interface DropdownProps {
  items: DropdownItem[];
  placeholder?: string;
  onSelect?: (item: DropdownItem) => void;
  className?: string;
}
