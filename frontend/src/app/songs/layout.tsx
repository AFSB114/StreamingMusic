// app/layout.js
"use client";

import { MusicProvider } from '@/context/MusicContext';

export default function RootLayout({ children }: Readonly<{ children: React.ReactNode }>) {
  return (
    <MusicProvider>
      {children}
    </MusicProvider>
  );
}