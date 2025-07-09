"use client";

import { createContext } from "react";
import type { GenreContextType } from "@/types";

export const GenreContext = createContext<GenreContextType | undefined>(
  undefined
);
