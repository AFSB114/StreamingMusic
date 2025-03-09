// app/layout.js
"use client";

import { SongProvider } from "@/context/providers/SongProvider";

export default function RootLayout({
  children,
}: Readonly<{ children: React.ReactNode }>) {
  return <SongProvider>{children}</SongProvider>;
}
