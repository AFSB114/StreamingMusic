"use client";

import { SubscriptionPlanProvider } from "@/context/providers/SubscriptionPlanProvider";

export default function SongLayout({
  children,
}: Readonly<{ children: React.ReactNode }>) {
  return <SubscriptionPlanProvider>{children}</SubscriptionPlanProvider>;
}
