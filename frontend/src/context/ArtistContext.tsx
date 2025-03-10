"use client";

import { createContext } from "react";
import type { ArtistContextType } from "@/types";

export const ArtistContext = createContext<ArtistContextType | undefined>(undefined);
