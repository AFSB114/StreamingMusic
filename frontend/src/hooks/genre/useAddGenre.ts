"use client";

import { useGenresList } from "@/hooks";
import { GenreType } from "@/types";
import { useRouter } from "next/navigation";
import { ChangeEvent, FormEvent, useState } from "react";

export default function useAddGenre() {
  const { addGenre } = useGenresList();
  const router = useRouter();

  const [formData, setFormData] = useState<
    Omit<GenreType, "id">
  >({
    name: "",
    description: "",
  });
  const [isLoading, setIsLoading] = useState(false);
  const [isSubmitting, setIsSubmitting] = useState(false);

  function handleChange(
    e: ChangeEvent<HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement>
  ) {
    const { name, value } = e.target;

    if (value === " ") return;

    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));
  }

  async function handleSubmit(e: FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setIsLoading(true);
    if (isSubmitting) return;
    setIsSubmitting(true);

    const newGenre = {
      name: formData.name,
      description: formData.description === "" ? null : formData.description,
    };

    try {
      addGenre(newGenre);
      setTimeout(() => {
        setIsLoading(false);
        router.push("/sections/genres");
      }, 500);
    } catch (error) {
      console.error(error);
    } finally {
      setIsSubmitting(false);
    }
  }

  return { formData, handleChange, handleSubmit, isLoading };
}
