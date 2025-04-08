"use client";

import { createContext } from "react";
import type { AlbumContextType } from "@/types";

export const AlbumContext = createContext<AlbumContextType | undefined>(
  undefined
);
