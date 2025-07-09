"use client";

import { useSubscriptionPlansList } from "@/hooks";
import { useParams, useRouter } from "next/navigation";
import { useEffect, useState, type ChangeEvent, type FormEvent } from "react";

export default function useEditSubscriptionPlan() {
  const { getSubscriptionPlanById, updateSubscriptionPlan } = useSubscriptionPlansList();
  const params = useParams();
  const router = useRouter();
  const id = parseInt(params.id as string);

  const [formData, setFormData] = useState({
    name: "",
    price: 0.0,
    duration: 1,
    features: "",
    audioQuality: 0,
    allowsDownloads: false,
    adFree: false,
  });

  const [isLoading, setIsLoading] = useState(false);
  const [isFound, setIsFound] = useState<boolean | null>(null);

  useEffect(() => {
    async function fetchPlan() {
      setIsFound(null);

      const planData = getSubscriptionPlanById(id);
      if (planData) {
        setIsFound(true);
        setFormData({
          name: planData.name || "",
          price: planData.price || 0.0,
          duration: planData.duration || 1,
          features: planData.features || "",
          audioQuality: planData.audioQuality || 0,
          allowsDownloads: !!planData.allowsDownloads,
          adFree: !!planData.adFree,
        });
      } else {
        setIsFound(false);
      }
    }

    fetchPlan();
  }, [id, getSubscriptionPlanById]);

  const handleChange = (
    e: ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ) => {
    const { name, value, type } = e.target;

    setFormData((prev) => ({
      ...prev,
      [name]: type === "number" ? Number(value) : value,
    }));
  };

  const handleCheckboxChange = (e: ChangeEvent<HTMLInputElement>) => {
    const { name, checked } = e.target;

    setFormData((prev) => ({
      ...prev,
      [name]: checked,
    }));
  };

  async function handleSubmit(e: FormEvent) {
    e.preventDefault();
    setIsLoading(true);

    updateSubscriptionPlan(id, formData);

    setTimeout(() => {
      setIsLoading(false);
      router.push("/sections/subscription-plans");
    }, 500);
  }

  return { formData, handleChange, handleCheckboxChange, handleSubmit, isLoading, isFound, id };
}
