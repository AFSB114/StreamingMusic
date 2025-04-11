"use client";

import CustomSelect from "@/components/CustomSelect";
import { artistTypes, countries } from "@/constants";
import { useAddArtist } from "@/hooks";
import Image from "next/image";
import { useRouter } from "next/navigation";
export { countries } from "@/constants";

export default function AddArtistPage() {
  const { formData, handleChange, handleSubmit, isLoading } = useAddArtist();
  const router = useRouter();

  return (
    <div className="w-full mx-auto p-6 bg-zinc-900 rounded-xl overflow-y-auto">
      <h2 className="text-2xl font-bold mb-6">Create Artist</h2>

      <form className="space-y-4" onSubmit={handleSubmit}>
        <div>
          <label htmlFor="name" className="block mb-1">
            Name
          </label>
          <input
            type="text"
            id="name"
            name="name"
            value={formData.name}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            required
            maxLength={255}
          />
        </div>

        <div>
          <label htmlFor="biography" className="block mb-1">
            Biography
          </label>
          <textarea
            id="biography"
            name="biography"
            value={formData.biography === null ? "" : formData.biography}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            rows={4}
          />
        </div>

        <div>
          <CustomSelect
            name="countryOfOrigin"
            label="Country of Origin"
            options={countries}
            value={
              formData.countryOfOrigin === null ? "" : formData.countryOfOrigin
            }
            onChange={handleChange}
            optionLabelKey="label"
            optionValueKey="value"
            placeholder="Select Country"
            maxHeight="150px"
            required
          />
        </div>

        <div>
          <label htmlFor="debutDate" className="block mb-1">
            Debut Date
          </label>
          <input
            type="date"
            id="debutDate"
            name="debutDate"
            value={formData.debutDate || ""} // Asegurar que no sea null
            onChange={handleChange}
            max={new Date().toISOString().split("T")[0]}
            min={new Date(1900, 0, 1).toISOString().split("T")[0]}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
          />
        </div>

        <div>
          <label htmlFor="imageUrl" className="block mb-1">
            Image URL
          </label>
          <input
            type="url"
            id="imageUrl"
            name="imageUrl"
            value={formData.imageUrl === null ? "" : formData.imageUrl}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            required
            readOnly
            maxLength={255}
          />
        </div>

        {formData.imageUrl && (
          <div>
            <Image
              src={formData.imageUrl}
              alt="Song cover"
              width={300}
              height={300}
              className="object-cover"
            />
          </div>
        )}

        <div>
          <CustomSelect
            name="type"
            label="Type"
            options={artistTypes}
            value={formData.type === null ? "" : formData.type}
            onChange={handleChange}
            optionLabelKey="label"
            optionValueKey="value"
            placeholder="Select Type"
            maxHeight="150px"
            required
          />
        </div>

        <div className="flex space-x-4 pt-4">
          <button
            type="button"
            className="px-4 py-2 rounded bg-zinc-700 hover:bg-zinc-600 transition-colors"
            onClick={() => router.push("/sections/artists")}
          >
            Cancel
          </button>
          <button
            type="submit"
            className="px-4 py-2 rounded bg-red-600 hover:bg-red-500 transition-colors"
            disabled={isLoading}
          >
            {isLoading ? "Saving..." : "Save"}
          </button>
        </div>
      </form>
    </div>
  );
}
