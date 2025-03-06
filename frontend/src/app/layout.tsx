import SideNav from "@/ui/SideNav";
import "./globals.css";

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body>
        <div className="flex h-screen flex-col md:flex-row md:overflow-hidden">
          <div className="w-full flex-none md:w-50">
            <SideNav />
          </div>
          <div className="flex-grow p-3 md:overflow-y-auto md:p-6 rounded-lg">
            {children}
          </div>
        </div>
      </body>
    </html>
  );
}
