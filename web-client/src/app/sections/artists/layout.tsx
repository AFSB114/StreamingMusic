"use client";

import { ArtistProvider } from "@/context/providers/ArtistProvider";

export default function ArtistLayout({
  children,
}: Readonly<{ children: React.ReactNode }>) {
  return <ArtistProvider>{children}</ArtistProvider>;
}
