"use client";

import { ArtistProvider } from "@/context/providers/ArtistProvider";
import { RecordLabelProvider } from "@/context/providers/RecordLabelProvider";
import { ReactNode } from "react";

export default function AddAlbumLayout({
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
