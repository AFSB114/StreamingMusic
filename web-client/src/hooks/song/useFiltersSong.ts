"use client";

import { useState, ChangeEvent, type FormEvent } from "react";
import { useSongsList } from "@/hooks";
import { filterEmptyValues } from "@/utils";

export default function useFiltersSong() {
  const { searchSongs } = useSongsList();

  const [filters, setFilters] = useState({
    search: "",
    genre: "",
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

    searchSongs(
      filterEmptyValues({
        name: filters.search,
        genre: filters.genre,
      })
    );
  };

  return { filters, handleChange, handleSubmit };
}
