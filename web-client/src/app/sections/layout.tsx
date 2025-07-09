import SideNav from "@/ui/SideNav";

export default function DashboardLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <div className="flex h-screen flex-col md:flex-row overflow-hidden">
      <div className="flex h-screen flex-col md:flex-row overflow-hidden w-full">
        <div className="w-full flex-none md:w-50">
          <SideNav />
        </div>
        <div className="flex-grow md:p-6 p-3 rounded-lg overflow-hidden flex flex-col">
          {children}
        </div>
      </div>
    </div>
  );
}
