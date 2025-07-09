"use client";

import { useSubscriptionPlanCard } from "@/hooks";
import { SubscriptionPlanType } from "@/types";
import {
  Card,
  CardContent,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/ui/Card";
import {
  Check,
  Download,
  Edit,
  Music,
  Trash2,
  Users,
  VideoOff,
} from "lucide-react";
import Link from "next/link";

export default function SubscriptionPlanCard({
  plan,
}: {
  plan: SubscriptionPlanType;
}) {
  const { handleDelete, handleQualityCategory } = useSubscriptionPlanCard({
    id: plan.id,
  });

  return (
    <Card
      className={`overflow-hidden ${
        plan.name === "Premium" ? "border-primary" : ""
      }`}
    >
      <CardHeader className="pb-2">
        <div className="text-center">
          <CardTitle>{plan.name}</CardTitle>
          {plan.price === 0 ? (
            <div className="mt-2">
              <span className="text-3xl font-bold">Free</span>
            </div>
          ) : (
            <div className="mt-2">
              <span className="text-3xl font-bold">${plan.price}</span>
              <span className="text-sm text-gray-500">/{plan.duration}d</span>
            </div>
          )}
        </div>
      </CardHeader>
      <CardContent>
        <div className="space-y-4">
          <div className="space-y-2">
            <div className="flex items-center gap-2">
              <Music size={16} className="text-gray-500" />
              <span className="text-sm">
                Calidad de audio: {handleQualityCategory(plan.audioQuality)}
              </span>
            </div>
            <div className="flex items-center gap-2">
              <Download size={16} className="text-gray-500" />
              <span className="text-sm">
                {plan.allowsDownloads
                  ? "Descargas permitidas"
                  : "Sin descargas"}
              </span>
            </div>
            {plan.adFree && (
              <div className="flex items-center gap-2">
                <VideoOff size={16} className="text-gray-500" />
                <span className="text-sm">Ad Free</span>
              </div>
            )}
            {plan.name === "Familiar" && (
              <div className="flex items-center gap-2">
                <Users size={16} className="text-gray-500" />
                <span className="text-sm">Hasta 6 cuentas</span>
              </div>
            )}
          </div>

          <div className="pt-2">
            <h4 className="text-sm font-medium mb-2">Características:</h4>
            {plan.features && (
              <ul className="space-y-1">
                {plan.features.split(", ").slice(0, 4).map((feature, index) => (
                  <li key={index} className="flex items-start gap-2 text-sm">
                    <Check
                      size={14}
                      className="text-green-500 mt-1 flex-shrink-0"
                    />
                    <span className="line-clamp-1">{feature}</span>
                  </li>
                ))}
              </ul>
            )}
          </div>
        </div>
      </CardContent>
      <CardFooter className="grid grid-cols-2 p-3 pb-0 gap-2">
        <Link
          href={`/sections/subscription-plans/${plan.id}/edit`}
          className="flex items-center justify-center gap-2 rounded-xl transition-colors duration-200 hover:bg-green-600 p-2 box-border"
        >
          <Edit className="h-[1em] w-[1em]" />
          <span>Edit</span>
        </Link>
        <button
          className="flex items-center justify-center gap-2 rounded-xl transition-colors duration-200 hover:bg-red-600 p-2 hover:cursor-pointer box-border"
          onClick={handleDelete}
        >
          <Trash2 className="h-[1em] w-[1em]" />
          <span>Delete</span>
        </button>
      </CardFooter>
    </Card>
  );
}
