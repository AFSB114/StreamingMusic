"use client";

import { useSubscriptionPlansList } from "@/hooks";

export default function useSubscriptionPlanCard({ id }: {id: number}) {
  const { deleteSubscriptionPlan } = useSubscriptionPlansList();

  const handleDelete = () => {
    deleteSubscriptionPlan(id);
  };

  const handleQualityCategory = (quality: number | null) => {
    if (quality === null) return "Unknown";
    if (quality >= 160 && quality <=320) return "High";
    if (quality >= 96 && quality <= 159) return "Medium";
    return "Low";
  };

  return { handleDelete, handleQualityCategory };
}
