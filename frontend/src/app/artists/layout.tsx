"use client";

import { ArtistProvider } from "@/context/ArtistContext";

export default function ArtistsLayout({
  children,
}: Readonly<{ children: React.ReactNode }>) {
  return <ArtistProvider>{children}</ArtistProvider>;
}
