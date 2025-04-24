"use client";

import SubscriptionPlanCard from "@/components/SubscriptionPlanCard";
import { useSubscriptionPlansList } from "@/hooks";
import { SubscriptionPlanType } from "@/types";
import { PlusCircle } from "lucide-react";
import Link from "next/link";

export default function SubscriptionPlanPage() {
  const { subscriptionPlansList } = useSubscriptionPlansList();

  return (
    <div className="relative overflow-y-auto max-h-full rounded-xl bg-zinc-900 p-3 shadow-sm">
      <div className="sticky top-0 z-40 flex justify-between items-center mb-5 bg-zinc-900 p-2 rounded-lg shadow-lg">
        <div className="w-max">
          <Link href="/sections/subscription-plans/add">
            <button className="text-1xl sm:text-2xl gap-2 rounded-xl flex flex-row items-center justify-center transition-colors duration-200 hover:bg-green-600 p-3 hover:cursor-pointer">
              <PlusCircle className="h-6 w-6" />
              <span>Add Subscription Plan</span>
            </button>
          </Link>
        </div>
      </div>

      <div className="grid sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-3">
        {subscriptionPlansList
          .sort((a, b) => a.id - b.id)
          .map((plan: SubscriptionPlanType) => (
            <SubscriptionPlanCard plan={plan} key={plan.id} />
          ))}
      </div>
    </div>
  )
};