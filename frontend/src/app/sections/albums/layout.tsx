"use client";

import { AlbumProvider } from "@/context/providers/AlbumProvider";
import { ReactNode } from "react";

export default function AlbumLayout({
  children,
}: Readonly<{ children: ReactNode }>) {
  return <AlbumProvider>{children}</AlbumProvider>;
}
