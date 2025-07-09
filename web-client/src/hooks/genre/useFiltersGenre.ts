"use client";

import { useState, ChangeEvent, type FormEvent } from "react";
import { useGenresList } from "@/hooks";
import { filterEmptyValues } from "@/utils";

export default function useFiltersArtist() {
  const { searchGenres } = useGenresList();

  const [filters, setFilters] = useState({
    search: "",
  });

  const handleChange = (
    e: ChangeEvent<HTMLInputElement | HTMLSelectElement>
  ) => {
    const { name, value } = e.target;

    if (value === " ") return;

    setFilters((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();

    searchGenres(
      filterEmptyValues({
        name: filters.search,
      })
    );
  };

  return { filters, handleChange, handleSubmit };
}
