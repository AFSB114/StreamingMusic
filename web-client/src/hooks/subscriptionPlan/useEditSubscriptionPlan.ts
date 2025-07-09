"use client";

import { useEffect, useState, type ChangeEvent, type FormEvent } from "react";
import { useParams, useRouter } from "next/navigation";
import { useSubscriptionPlansList } from "@/hooks";

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
  const [isFound, setIsFound] = useState<null | boolean>(null);

  useEffect(() => {
    const fetchData = async () => {
      const data = await getSubscriptionPlanById(id);

      if (!data) {
        setIsFound(false);
        return;
      }

      setFormData({
        name: data.name || "",
        price: data.price || 0.0,
        duration: data.duration || 1,
        features: data.features || "",
        audioQuality: data.audioQuality || 0,
        allowsDownloads: !!data.allowsDownloads,
        adFree: !!data.adFree,
      });

      setIsFound(true);
    };

    fetchData();
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

    const updatedPlan = {
      name: formData.name,
      price: formData.price,
      duration: formData.duration,
      features: formData.features || null,
      audioQuality: formData.audioQuality || null,
      allowsDownloads: formData.allowsDownloads,
      adFree: formData.adFree,
    };

    await updateSubscriptionPlan(id, updatedPlan);

    setTimeout(() => {
      setIsLoading(false);
      router.push("/sections/subscription-plans");
    }, 500);
  }

  return {
    formData,
    handleChange,
    handleCheckboxChange,
    handleSubmit,
    isLoading,
    isFound,
    id,
  };
}
