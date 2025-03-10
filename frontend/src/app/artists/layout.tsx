"use client";

import { ArtistProvider } from "@/context/providers/ArtistProvider";

export default function ArtistsLayout({
  children,
}: Readonly<{ children: React.ReactNode }>) {
  return <ArtistProvider>{children}</ArtistProvider>;
}
