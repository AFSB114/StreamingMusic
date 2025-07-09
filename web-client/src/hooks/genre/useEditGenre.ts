"use client";

import { useGenresList } from "@/hooks";
import { GenreType } from "@/types";
import { useParams, useRouter } from "next/navigation";
import { ChangeEvent, FormEvent, useEffect, useState } from "react";

export default function useAddGenre() {
  const { getGenreById, updateGenre } = useGenresList();
  const params = useParams();
  const router = useRouter();
  const id = parseInt(params.id as string);

  const [formData, setFormData] = useState<Omit<GenreType, "id">>({
    name: "",
    description: "",
  });
  const [isLoading, setIsLoading] = useState(false);
  const [isFound, setIsFound] = useState<boolean | null>(false);

  useEffect(() => {
    async function fetchGenres() {
      setIsFound(null);

      const genreData = getGenreById(id);
      if (genreData) {
        setIsFound(true);
        setFormData({
          name: genreData.name,
          description: genreData.description,
        });
      } else {
        setIsFound(false);
      }
    }

    fetchGenres();
  }, [id, getGenreById]);

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

    try {
      updateGenre(id, formData);
      setTimeout(() => {
        setIsLoading(false);
        router.push("/sections/genres");
      }, 500);
    } catch (error) {
      console.error(error);
    }
  }

  return { formData, handleChange, handleSubmit, isLoading, isFound, id };
}
