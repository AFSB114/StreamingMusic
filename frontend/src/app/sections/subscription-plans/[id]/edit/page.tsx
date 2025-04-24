"use client";

import { useEditSubscriptionPlan } from "@/hooks";
import Loading from "@/ui/Loading";
import NotFound from "@/ui/NotFound";
import { useRouter } from "next/navigation";

export default function EditSubscriptionPlanPage() {
  const {
    formData,
    handleChange,
    handleCheckboxChange,
    handleSubmit,
    isLoading,
    isFound,
    id,
  } = useEditSubscriptionPlan();
  const router = useRouter();

  if (isFound === null) {
    return <Loading />;
  }

  if (!isFound) {
    return <NotFound section="Subscription Plan" />;
  }

  return (
    <div className="w-full mx-auto p-6 bg-zinc-900 rounded-xl overflow-y-auto">
      <h2 className="text-2xl font-bold mb-6">Edit Subscription Plan {id}</h2>

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
            maxLength={100}
          />
        </div>

        <div>
          <label htmlFor="price" className="block mb-1">
            Price
          </label>
          <input
            type="number"
            id="price"
            name="price"
            value={formData.price}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            required
            min={0}
            step="0.01"
          />
        </div>

        <div>
          <label htmlFor="duration" className="block mb-1">
            Duration (in days)
          </label>
          <input
            type="number"
            id="duration"
            name="duration"
            value={formData.duration}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            required
            min={1}
          />
        </div>

        <div>
          <label htmlFor="features" className="block mb-1">
            Features
          </label>
          <p className="text-sm text-zinc-400">Separate features with a comma</p>
          <textarea
            id="features"
            name="features"
            value={formData.features || ""}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            rows={3}
            maxLength={500}
          />
        </div>

        <div>
          <label htmlFor="audioQuality" className="block mb-1">
            Audio Quality (kbps)
          </label>
          <input
            type="number"
            id="audioQuality"
            name="audioQuality"
            value={formData.audioQuality}
            onChange={handleChange}
            className="w-full p-2 rounded bg-zinc-800 border border-zinc-700 focus:outline-none focus:ring-red-800 focus:border-red-800 caret-red-500"
            min={0}
            max={320}
          />
        </div>

        <div className="flex items-center">
          <input
            type="checkbox"
            id="allowsDownloads"
            name="allowsDownloads"
            checked={formData.allowsDownloads}
            onChange={handleCheckboxChange}
            className="mr-2"
          />
          <label htmlFor="allowsDownloads">Allows Downloads</label>
        </div>

        <div className="flex items-center">
          <input
            type="checkbox"
            id="adFree"
            name="adFree"
            checked={formData.adFree}
            onChange={handleCheckboxChange}
            className="mr-2"
          />
          <label htmlFor="adFree">Ad-Free</label>
        </div>

        <div className="flex space-x-4 pt-4">
          <button
            type="button"
            className="px-4 py-2 rounded bg-zinc-700 hover:bg-zinc-600 transition-colors"
            onClick={() => router.push("/sections/subscription-plans")}
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
