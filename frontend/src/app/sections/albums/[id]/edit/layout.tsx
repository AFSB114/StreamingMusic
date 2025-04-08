"use client";

import { ArtistProvider } from "@/context/providers/ArtistProvider";
import { RecordLabelProvider } from "@/context/providers/RecordLabelProvider";
import { ReactNode } from "react";

export default function EditAlbumLayout({
  children,
}: Readonly<{ children: ReactNode }>) {
  return (
    <ArtistProvider>
      <RecordLabelProvider>
        {children}
      </RecordLabelProvider>
    </ArtistProvider>
  );
}