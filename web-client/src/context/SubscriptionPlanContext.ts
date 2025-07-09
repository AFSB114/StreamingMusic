"use client";

import { createContext } from "react";
import type { SubscriptionPlanContextType } from "@/types";

export const SubscriptionPlanContext = createContext<SubscriptionPlanContextType | undefined>(undefined);