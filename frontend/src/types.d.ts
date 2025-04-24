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
export interface selectOptionsType{
  label: string;
  value: string | number;
}

export type OptionType = Record<string, string | number>;

interface CustomSelectProps<T> {
  name: string;
  label: string;
  options: T[];
  value: string;
  onChange: (e: ChangeEvent<HTMLInputElement | HTMLSelectElement>) => void;
  optionLabelKey: keyof T;
  optionValueKey: keyof T;
  placeholder?: string;
  maxHeight?: string;
  required?: boolean;
  variant?: string;
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

export interface AlbumType {
  id: number;
  artistId: Partial<ArtistType>;
  recordLabelId: Partial<RecordLabelType>;
  title: string;
  releaseDate: string;
  coverUrl: string | null;
  type: string | null;
  totalDuration: number | null;
  description: string | null;
}

export interface AlbumContextType {
  albumsList: AlbumType[];
  addAlbum: (newAlbum: Omit<AlbumType, "id" | "totalDuration">) => void;
  deleteAlbum: (id: number) => void;
  getAlbumById: (id: number) => AlbumType | null;
  updateAlbum: (id: number, updatedAlbum: Partial<AlbumType>) => void;
  searchAlbums: (params: Record<string, string>) => void;
}

export interface GenreType {
  id: number;
  name: string;
  description: string | null;
}

export interface GenreContextType {
  genresList: GenreType[];
  addGenre: (newGenre: Omit<GenreType, "id">) => void;
  deleteGenre: (id: number) => void;
  getGenreById: (id: number) => GenreType | null;
  updateGenre: (id: number, updatedGenre: Partial<GenreType>) => void;
  searchGenres: (params: Record<string, string>) => void;
}

export interface SongType {
  id: number;
  albumId: Partial<AlbumType> | null;
  artistId: Partial<ArtistType>;
  genreId: Partial<GenreType> | null;
  title: string;
  composer: string | null;
  duration: number;
  lyrics: string | null;
  releaseDate: string | null;
  fileUrl: string | null;
  imageUrl: string | null;
}

export interface SongContextType {
  songsList: SongType[];
  addSong: (newSong: Omit<SongType, "id" | "trackNumber">) => void;
  deleteSong: (id: number) => void;
  getSongById: (id: number) => SongType | null;
  updateSong: (id: number, updatedSong: Partial<SongType>) => void;
  searchSongs: (params: Record<string, string>) => void;
}

export interface SubscriptionPlanType {
  id: number;
  name: string;
  price: float;
  duration: number;
  features: string | null;
  audioQuality: number | null;
  allowsDownloads: boolean;
  adFree: boolean;
}

export interface SubscriptionPlanContextType {
  subscriptionPlansList: SubscriptionPlanType[];
  addSubscriptionPlan: (newSubscriptionPlan: Omit<SubscriptionPlanType, "id">) => void;
  deleteSubscriptionPlan: (id: number) => void;
  getSubscriptionPlanById: (id: number) => SubscriptionPlanType | null;
  updateSubscriptionPlan: (id: number, updatedSubscriptionPlan: Partial<SubscriptionPlanType>) => void;
  searchSubscriptionPlans: (params: Record<string, string>) => void;
}

export interface UserType {
  id: number;
  name: string;
  email: string;
  password: string;
  registrationDate: string;
  country: string | null;
  profileImage: string | null;
  active: boolean;
}

export interface UserContextType {
  usersList: Omit<UserType, "password">[];
  addUser: (newUser: Omit<UserType, "id" | "registrationDate" | "isActive">) => void;
  deleteUser: (id: number) => void;
  getUserById: (id: number) => UserType | null;
  updateUser: (id: number, updatedUser: Partial<UserType>) => void;
  searchUsers: (params: Record<string, string>) => void;
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
