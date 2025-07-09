"use client";

import { RecordLabelProvider } from "@/context/providers/RecordLabelProvider";

export default function RecordLabelLayout({
  children,
}: Readonly<{ children: React.ReactNode }>) {
  return <RecordLabelProvider>{children}</RecordLabelProvider>;
}
