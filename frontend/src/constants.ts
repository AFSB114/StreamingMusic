import { LinkType } from "@/types";

export const links: LinkType[] = [
  { name: "Home", href: "/" },
  { name: "Artists", href: "/sections/artists" },
  { name: "Record Labels", href: "/sections/record-labels" },
  { name: "Albums", href: "/sections/albums" },
  { name: "Genres", href: "/sections/genres" },
];

export const albumTypes = [
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
