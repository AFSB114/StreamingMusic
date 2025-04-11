import { LinkType, selectOptionsType } from "@/types";

export const links: LinkType[] = [
  { name: "Home", href: "/" },
  { name: "Artists", href: "/sections/artists" },
  { name: "Record Labels", href: "/sections/record-labels" },
  { name: "Albums", href: "/sections/albums" },
  { name: "Genres", href: "/sections/genres" },
  { name: "Songs", href: "/sections/songs" },
];

export const countries: selectOptionsType[]= [
  { value: "AR", label: "Argentina" },
  { value: "BR", label: "Brasil" },
  { value: "CL", label: "Chile" },
  { value: "CO", label: "Colombia" },
  { value: "MX", label: "México" },
  { value: "PE", label: "Perú" },
  { value: "VE", label: "Venezuela" },
  { value: "UY", label: "Uruguay" },
  { value: "PY", label: "Paraguay" },
  { value: "BO", label: "Bolivia" },
  { value: "EC", label: "Ecuador" },
  { value: "DO", label: "República Dominicana" },
  { value: "HN", label: "Honduras" },
  { value: "SV", label: "El Salvador" },
  { value: "GT", label: "Guatemala" },
  { value: "CR", label: "Costa Rica" },
  { value: "NI", label: "Nicaragua" },
  { value: "PA", label: "Panamá" },
  { value: "CU", label: "Cuba" },
  { value: "PR", label: "Puerto Rico" },
  { value: "JM", label: "Jamaica" },
  { value: "HT", label: "Haití" },
  { value: "BZ", label: "Belice" },
  { value: "GY", label: "Guyana" },
  { value: "SR", label: "Surinam" },
];

export const artistTypes: selectOptionsType[] = [
  { label: 'Cantante', value: 'singer' },
  { label: 'Banda', value: 'band' },
  { label: 'Productor musical', value: 'producer' },
  { label: 'DJ', value: 'dj' },
  { label: 'Compositor', value: 'composer' },
  { label: 'Instrumentista', value: 'instrumentalist' },
  { label: 'Rapper', value: 'rapper' },
  { label: 'Guitarrista', value: 'guitarist' },
  { label: 'Pianista', value: 'pianist' },
  { label: 'Bajista', value: 'bassist' },
  { label: 'Percusionista', value: 'percussionist' },
  { label: 'Cantautor', value: 'singer-songwriter' },
  { label: 'Orquesta', value: 'orchestra' },
  { label: 'Corista', value: 'chorus' },
  { label: 'Solista', value: 'soloist' }
];

export const albumTypes: selectOptionsType[] = [
  { label: "Studio Album", value: "studio" },
  { label: "Live Album", value: "live" },
  { label: "Compilation", value: "compilation" },
  { label: "EP (Extended Play)", value: "ep" },
  { label: "Single", value: "single" },
  { label: "Remix Album", value: "remix" },
  { label: "Soundtrack", value: "soundtrack" },
  { label: "Mixtape", value: "mixtape" },
  { label: "Demo", value: "demo" },
  { label: "Cover Album", value: "cover" },
];
