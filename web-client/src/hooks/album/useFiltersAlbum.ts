"use client";

import { useState, ChangeEvent, type FormEvent } from "react";
import { useAlbumsList } from "@/hooks";
import { filterEmptyValues } from "@/utils";

export default function useFiltersAlbum() {
  const { searchAlbums } = useAlbumsList();

  const [filters, setFilters] = useState({
    search: "",
    type: "",
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

    searchAlbums(
      filterEmptyValues({
        name: filters.search,
        type: filters.type,
      })
    );
  };

  return { filters, handleChange, handleSubmit };
}
