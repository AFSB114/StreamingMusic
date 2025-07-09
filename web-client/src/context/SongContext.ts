"use client";

import { createContext } from "react";
import type { SongContextType } from "@/types";

export const SongContext = createContext<SongContextType | undefined>(undefined);
