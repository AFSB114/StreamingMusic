"use client";

import { createContext } from "react";
import type { RecordLabelContextType } from "@/types";

export const RecordLabelContext = createContext<
  RecordLabelContextType | undefined
>(undefined);
