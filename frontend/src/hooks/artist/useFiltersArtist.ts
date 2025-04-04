import { useState, ChangeEvent, type FormEvent } from "react";
import { useArtistsList } from "@/hooks";
import { filterEmptyValues } from "@/utils";

export default function useFiltersArtist() {
  const { searchArtists } = useArtistsList();

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

    searchArtists(filterEmptyValues({
      name: filters.search,
      type: filters.type,
    }));
  };

  return { filters, handleChange, handleSubmit };
}
