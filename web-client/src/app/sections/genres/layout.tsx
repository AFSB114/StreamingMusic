"use client";

import { GenreProvider } from "@/context/providers/GenreProvider";

export default function ArtistLayout({
  children,
}: Readonly<{ children: React.ReactNode }>) {
  return <GenreProvider>{children}</GenreProvider>;
}
