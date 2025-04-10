import { LinkType, selectOptionsType } from "@/types";

export const links: LinkType[] = [
  { name: "Home", href: "/" },
  { name: "Artists", href: "/sections/artists" },
  { name: "Record Labels", href: "/sections/record-labels" },
  { name: "Albums", href: "/sections/albums" },
  { name: "Genres", href: "/sections/genres" },
  { name: "Songs", href: "/sections/songs" },
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
