// app/layout.js
"use client";

import { GenreProvider } from "@/context/providers/GenreProvider";
import { SongProvider } from "@/context/providers/SongProvider";

export default function SongLayout({
  children,
}: Readonly<{ children: React.ReactNode }>) {
  return (
    <SongProvider>
      <GenreProvider>{children}</GenreProvider>
    </SongProvider>
  );
}
