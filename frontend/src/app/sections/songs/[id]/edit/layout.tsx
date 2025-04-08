"use client";

import { AlbumProvider } from "@/context/providers/AlbumProvider";
import { ArtistProvider } from "@/context/providers/ArtistProvider";
import { ReactNode } from "react";

export default function EditSongLayout({
  children,
}: Readonly<{ children: ReactNode }>) {
  return (
    <ArtistProvider>
      <AlbumProvider>
       {children}
      </AlbumProvider>
    </ArtistProvider>
  );
}
