"use client";

import { useState, ChangeEvent, type FormEvent } from "react";
import { useRecordLabelsList } from "@/hooks";
import { filterEmptyValues } from "@/utils";

export default function useFiltersRecordLabel() {
  const { searchRecordLabels } = useRecordLabelsList();

  const [filters, setFilters] = useState({
    search: "",
    country: "",
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

    searchRecordLabels(
      filterEmptyValues({
        name: filters.search,
        country: filters.country,
      })
    );
  };

  return { filters, handleChange, handleSubmit };
}