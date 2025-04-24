"use client";

import { useState, type ChangeEvent, type FormEvent } from "react";
import { useRouter } from "next/navigation";

// Suponiendo que tienes un hook para manejar plans
import { useSubscriptionPlansList } from "@/hooks";

export default function useAddSubscriptionPlan() {
  const { addSubscriptionPlan } = useSubscriptionPlansList();
  const router = useRouter();

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

    const newPlan = {
      name: formData.name,
      price: formData.price,
      duration: formData.duration,
      features: formData.features || null,
      audioQuality: formData.audioQuality || null,
      allowsDownloads: formData.allowsDownloads,
      adFree: formData.adFree,
    };

    // Puedes hacer validaciones aquí si necesitas
    // console.log(newPlan);

    addSubscriptionPlan(newPlan);

    setTimeout(() => {
      setIsLoading(false);
      router.push("/sections/subscription-plans");
    }, 500);
  }

  return { formData, handleChange, handleCheckboxChange, handleSubmit, isLoading };
}
