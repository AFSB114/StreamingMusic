import { useContext } from "react";
import type { SubscriptionPlanContextType } from "@/types";
import { SubscriptionPlanContext } from "@/context/SubscriptionPlanContext";

export default function useSubscriptionPlansList(): SubscriptionPlanContextType {
  const context = useContext(SubscriptionPlanContext);
  if (!context) {
    throw new Error("useSubscriptionPlan must be used within a SubscriptionPlanProvider");
  }
  return context;
};