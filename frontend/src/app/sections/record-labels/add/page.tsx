"use client";

import { useRouter } from "next/navigation";
import useAddRecordLabel from "@/hooks/recordLabel/useAddRecordLabel";
import Image from "next/image";
import CustomSelect from "@/components/CustomSelect";
import { countries } from "@/constants";

export default function CreateRecordLabelForm() {
  const { formData, handleChange, handleSubmit, isLoading } =
    useAddRecordLabel();
  const router = useRouter();

  return (
    <div className="w-full mx-auto p-6 bg-zinc-900 rounded-xl overflow-y-auto">
      <h2 className="text-2xl font-bold mb-6">Create Record Label</h2>

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
            maxLength={150}
          />
        </div>

        <div>
          <CustomSelect
            name="country"
            label="Country"
            options={countries}
            value={
              formData.country === null ? "" : formData.country
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
          <label htmlFor="foundationDate" className="block mb-1">
            Foundation Date
          </label>
          <input
            type="date"
            id="foundationDate"
            name="foundationDate"
            value={
              formData.foundationDate === null ? "" : formData.foundationDate
            }
            onChange={handleChange}
            max={new Date().toISOString().split("T")[0]}
            min={new Date(1900, 0, 1).toISOString().split("T")[0]}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
          />
        </div>

        <div>
          <label htmlFor="logoUrl" className="block mb-1">
            Logo URL
          </label>
          <input
            type="url"
            id="logoUrl"
            name="logoUrl"
            value={formData.logoUrl === null ? "" : formData.logoUrl}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            required
            readOnly
          />
        </div>

        {formData.logoUrl && (
          <div>
            <Image
              src={formData.logoUrl}
              alt="Record label logo"
              width={300}
              height={300}
              className="object-cover rounded"
            />
          </div>
        )}

        <div>
          <label htmlFor="website" className="block mb-1">
            Website
          </label>
          <input
            type="url"
            id="website"
            name="website"
            value={formData.website === null ? "" : formData.website}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            required
            readOnly
          />
        </div>

        <div className="flex space-x-4 pt-4">
          <button
            type="button"
            className="px-4 py-2 rounded bg-zinc-700 hover:bg-zinc-600 transition-colors"
            onClick={() => router.push("/sections/record-labels")}
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
