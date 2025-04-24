"use client";

import { useState, type FormEvent, type ChangeEvent } from "react";
import useArtistsList from "@/hooks/artist/useArtistsList";
import { type ArtistType } from "@/types";
import { useRouter } from "next/navigation";

export default function useAddArtist() {
  const { addArtist } = useArtistsList();
  const router = useRouter();

  const [formData, setFormData] = useState<Omit<ArtistType, "id">>({
    name: "",
    biography: "",
    countryOfOrigin: "",
    debutDate: "",
    imageUrl: "https://picsum.photos/seed//300/300",
    type: "",
  });
  const [isLoading, setIsLoading] = useState(false);
  const [ isSubmitting, setIsSubmitting ] = useState(false);

  function handleChange(
    e: ChangeEvent<HTMLInputElement | HTMLTextAreaElement | HTMLSelectElement>
  ) {
    const { name, value } = e.target;

    if (value === " ") return;

    if (name === "name") {
      const formattedName = value.trim().replace(/\s+/g, "").toLowerCase();
      setFormData((prev) => ({
        ...prev,
        name: value,
        imageUrl: `https://picsum.photos/seed/${formattedName}/300/300`,
      }));
    } else {
      setFormData((prev) => ({
        ...prev,
        [name]: value,
      }));
    }
  }

  async function handleSubmit(e: FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setIsLoading(true);
    if (isSubmitting) return;
    setIsSubmitting(true);

    const newArtist = {
      name: formData.name,
      biography: formData.biography === "" ? null : formData.biography,
      countryOfOrigin:
        formData.countryOfOrigin === "" ? null : formData.countryOfOrigin,
      debutDate: formData.debutDate === "" ? null : formData.debutDate,
      imageUrl: formData.imageUrl,
      type: formData.type === "" ? null : formData.type,
    };

    try {
      await addArtist(newArtist);
      setTimeout(() => {
        setIsLoading(false);
        router.push("/sections/artists");
      }, 500); 
    } catch (error) {
      console.error(error);
    } finally {
      setIsSubmitting(false);
    }
  }

  return { formData, handleChange, handleSubmit, isLoading };
}
